package net.minixalpha.chap19;

import static net.mindview.util.Print.print;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;

import net.minixalpha.chap19.PostOffice.MailHandler;

interface Handler {
	boolean handle(Mail m);
};

class PostOffice2 {

	private static EnumMap<MailHandler, Handler> handleMap = new EnumMap<>(
			MailHandler.class);

	enum MailHandler {
		GENERAL_DELIVERY, MACHINE_SCAN, VISUAL_INSPECTION, FOWARD, RETURN_TO_SENDER
	};

	static {
		handleMap.put(MailHandler.GENERAL_DELIVERY, new Handler() {
			public boolean handle(Mail m) {
				switch (m.generalDelivery) {
				case YES:
					print("Using general delivery for " + m);
					return true;
				default:
					return false;
				}
			}
		});

		handleMap.put(MailHandler.MACHINE_SCAN, new Handler() {
			@Override
			public boolean handle(Mail m) {
				switch (m.scannability) {
				case UNSCANNABLE:
					return false;
				default:
					switch (m.address) {
					case INCORRECT:
						return false;
					default:
						print("Delivering " + m + " automatically");
						return true;
					}
				}
			}
		});

		handleMap.put(MailHandler.VISUAL_INSPECTION, new Handler() {

			@Override
			public boolean handle(Mail m) {
				switch (m.readability) {
				case ILLEGIBLE:
					return false;
				default:
					switch (m.address) {
					case INCORRECT:
						return false;
					default:
						print("Delivering " + m + " normally");
						return true;
					}
				}
			}
		});

		handleMap.put(MailHandler.FOWARD, new Handler() {

			@Override
			public boolean handle(Mail m) {
				switch (m.forwardability) {
				case YES:
					System.err.println("Forward " + m);
					return true;
				default:
					return false;
				}
			}
		});

		handleMap.put(MailHandler.RETURN_TO_SENDER, new Handler() {

			@Override
			public boolean handle(Mail m) {
				switch (m.returnAddress) {
				case MISSING:
					return false;
				default:
					print("Returning " + m + " to sender");
					return true;
				}
			}
		});

	}

	static void handle(Mail m) {
		for (Entry<MailHandler, Handler> entry : handleMap.entrySet())
			if (entry.getValue().handle(m))
				return;
		print(m + " is a dead letter");
	}

	public static void main(String[] args) {
		for (Mail mail : Mail.generator(20)) {
			print(mail.details());
			handle(mail);
			print("*****");
		}
	}
}

public class Ex9 {
	public static void main(String[] args) {

	}
}
