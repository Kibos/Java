package net.minixalpha.chap19;

import java.util.*;

import net.mindview.util.*;
import static net.minixalpha.chap19.Input.*;
import static net.mindview.util.Print.*;

class Good {
	public String name;
	public Integer price;
	public String category;

	public Good(String name, Integer price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}

	@Override
	public String toString() {
		return name + " " + price + " " + category;
	}
}

class SoldGoods {
	private static String confPath = "goods.conf";
	private ArrayList<Good> goods = new ArrayList<>();
	private Random rand = new Random();

	public SoldGoods() {
		this(confPath);
	}

	public SoldGoods(String confPath) {
		String content = TextFile.read(confPath);
		String[] lines = content.split("\\n");
		for (String line : lines) {
			String[] s = line.split(" ");
			Good g = new Good(s[0], Integer.parseInt(s[1]), s[2]);
			goods.add(g);
		}
	}

	@Override
	public String toString() {
		return goods.toString();
	}

	public ArrayList<Good> getGoods() {
		return goods;
	}

	public static void main(String[] args) {
		SoldGoods goods = new SoldGoods();
		System.out.println(goods);
	}

	public Good randomSelection() {
		Good good = goods.get(rand.nextInt(goods.size() - 1)); // Exclude the last STOP
		return good;
	}
}

enum Category2 {
	MONEY, ITEM_SELECTION, QUIT_TRANSACTION, SHUT_DOWN;
}

class VendingMachine2 {
	private static State state = State.RESTING;
	private static int amount = 0;
	private static Good selection = null;

	enum StateDuration {
		TRANSIENT
	} // Tagging enum

	enum State {
		RESTING {
			void next(Good input) {
				switch (Enum.valueOf(Category2.class, input.category)) {
				case MONEY:
					amount += input.price;
					state = ADDING_MONEY;
					break;
				case SHUT_DOWN:
					state = TERMINAL;
				default:
				}
			}
		},
		ADDING_MONEY {
			void next(Good input) {
				switch (Enum.valueOf(Category2.class, input.category)) {
				case MONEY:
					amount += input.price;
					break;
				case ITEM_SELECTION:
					selection = input;
					if (amount < selection.price)
						print("Insufficient money for " + selection);
					else
						state = DISPENSING;
					break;
				case QUIT_TRANSACTION:
					state = GIVING_CHANGE;
					break;
				case SHUT_DOWN:
					state = TERMINAL;
				default:
				}
			}
		},
		DISPENSING(StateDuration.TRANSIENT) {
			void next() {
				print("here is your " + selection);
				amount -= selection.price;
				state = GIVING_CHANGE;
			}
		},
		GIVING_CHANGE(StateDuration.TRANSIENT) {
			void next() {
				if (amount > 0) {
					print("Your change: " + amount);
					amount = 0;
				}
				state = RESTING;
			}
		},
		TERMINAL {
			void output() {
				print("Halted");
			}
		};
		private boolean isTransient = false;

		State() {
		}

		State(StateDuration trans) {
			isTransient = true;
		}

		void next(Good input) {
			throw new RuntimeException("Only call "
					+ "next(Good input) for non-transient states");
		}

		void next() {
			throw new RuntimeException("Only call next() for "
					+ "StateDuration.TRANSIENT states");
		}

		void output() {
			print(amount);
		}
	}

	static void run(SoldGoods soldGoods) {
		while (state != State.TERMINAL) {
			state.next(soldGoods.randomSelection());
			while (state.isTransient)
				state.next();
			state.output();
		}
	}

	public static void main(String[] args) {
		SoldGoods soldGoods = new SoldGoods();
		run(soldGoods);
	}
}

public class Ex11 {
	public static void main(String[] args) {
		// Complete the class to read configure from file
		// But do not know how to use it in VendingMachine2 and Category2
	}
}
