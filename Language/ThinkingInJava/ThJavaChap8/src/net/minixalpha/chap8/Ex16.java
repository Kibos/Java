package net.minixalpha.chap8;

import java.lang.Thread.State;

abstract class AlertStatus {
	@Override
	public abstract String toString();
}

class Normal extends AlertStatus {

	@Override
	public String toString() {
		return "Normal";
	}
}

class Medium extends AlertStatus {

	@Override
	public String toString() {
		return "Medium";
	}
}

class HighRisk extends AlertStatus {

	@Override
	public String toString() {
		return "HighRisk";
	}
}

class Starship {
	private AlertStatus status = new Normal();

	public void change(int code) {
		switch (code) {
		case 0:
			status = new Normal();
			break;
		case 1:
			status = new Medium();
			break;
		case 2:
			status = new HighRisk();
			break;
		default:
			break;
		}
	}

	public String getState() {
		return status.toString();
	}
}

public class Ex16 {
	public static void main(String[] args) {
		Starship ship = new Starship();
		System.out.println(ship.getState());
		ship.change(1);
		System.out.println(ship.getState());
		ship.change(2);
		System.out.println(ship.getState());
	}
}
