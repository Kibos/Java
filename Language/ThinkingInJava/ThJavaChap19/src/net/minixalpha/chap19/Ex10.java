package net.minixalpha.chap19;

import java.util.*;
import net.mindview.util.*;
import static net.minixalpha.chap19.Input.*;
import static net.mindview.util.Print.*;

enum Category {
	MONEY(NICKEL, DIME, QUARTER, DOLLAR), ITEM_SELECTION(TOOTHPASTE, CHIPS,
			SODA, SOAP), QUIT_TRANSACTION(ABORT_TRANSACTION), SHUT_DOWN(STOP);
	private Input[] values;

	Category(Input... types) {
		values = types;
	}

	private static EnumMap<Input, Category> categories = new EnumMap<Input, Category>(
			Input.class);
	static {
		for (Category c : Category.class.getEnumConstants())
			for (Input type : c.values)
				categories.put(type, c);
	}

	public static Category categorize(Input input) {
		return categories.get(input);
	}
}

abstract class Action {
	void next(Input input) {
	}

	void next() {
	}

	void output() {
	}
}

class VendingMachine {
	private State state = State.RESTING;
	private int amount = 0;
	private Input selection = null;

	enum StateDuration {
		TRANSIENT
	} // Tagging enum

	private EnumMap<State, Action> stateActionMap = new EnumMap<>(State.class);

	public VendingMachine() {
		stateActionMap.put(State.RESTING, new Action() {

			@Override
			public void next(Input input) {
				switch (Category.categorize(input)) {
				case MONEY:
					amount += input.amount();
					state = State.ADDING_MONEY;
					break;
				case SHUT_DOWN:
					state = State.TERMINAL;
				default:
				}
			}
		});

		stateActionMap.put(State.ADDING_MONEY, new Action() {

			@Override
			public void next(Input input) {
				switch (Category.categorize(input)) {
				case MONEY:
					amount += input.amount();
					break;
				case ITEM_SELECTION:
					selection = input;
					if (amount < selection.amount())
						print("Insufficient money for " + selection);
					else
						state = State.DISPENSING;
					break;
				case QUIT_TRANSACTION:
					state = State.GIVING_CHANGE;
					break;
				case SHUT_DOWN:
					state = State.TERMINAL;
				default:
				}
			}
		});

		stateActionMap.put(State.DISPENSING, new Action() {

			@Override
			public void next() {
				print("here is your " + selection);
				amount -= selection.amount();
				state = State.GIVING_CHANGE;
			}
		});

		stateActionMap.put(State.GIVING_CHANGE, new Action() {
			void next() {
				if (amount > 0) {
					print("Your change: " + amount);
					amount = 0;
				}
				state = State.RESTING;
			}
		});

		stateActionMap.put(State.TERMINAL, new Action() {
			void output() {
				print("Halted");
			}
		});
	}

	enum State {
		RESTING, ADDING_MONEY, DISPENSING(StateDuration.TRANSIENT) {
		},
		GIVING_CHANGE(StateDuration.TRANSIENT) {
		},
		TERMINAL;

		private boolean isTransient = false;

		State() {
		}

		State(StateDuration trans) {
			isTransient = true;
		}

		void next(Input input) {
			throw new RuntimeException("Only call "
					+ "next(Input input) for non-transient states");
		}

		void next() {
			throw new RuntimeException("Only call next() for "
					+ "StateDuration.TRANSIENT states");
		}

		void output(int amount) {
			print(amount);
		}
	}

	void run(Generator<Input> gen) {
		while (state != State.TERMINAL) {

			stateActionMap.get(state).next(gen.next());
			while (state.isTransient)
				stateActionMap.get(state).next();
			state.output(this.amount);
		}
	}

	public static void main(String[] args) {
		Generator<Input> gen = new RandomInputGenerator();
		if (args.length == 1)
			gen = new FileInputGenerator(args[0]);

		VendingMachine machine1 = new VendingMachine();
		machine1.run(gen);

		VendingMachine machine2 = new VendingMachine();
		machine2.run(gen);
	}
}

// For a basic sanity check:
class RandomInputGenerator implements Generator<Input> {
	public Input next() {
		return Input.randomSelection();
	}
}

// Create Inputs from a file of ';'-separated strings:
class FileInputGenerator implements Generator<Input> {
	private Iterator<String> input;

	public FileInputGenerator(String fileName) {
		input = new TextFile(fileName, ";").iterator();
	}

	public Input next() {
		if (!input.hasNext())
			return null;
		return Enum.valueOf(Input.class, input.next().trim());
	}
}

public class Ex10 {
	public static void main(String[] args) {
		// Do not sure whether I got it or not.
	}
}
