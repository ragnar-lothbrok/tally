package test.chegg;

class CDE implements javafx.event.EventHandler<javafx.event.ActionEvent> {

	@Override
	public void handle(javafx.event.ActionEvent event) {
		System.out.println(event);
	}

}

public class TESTLAMBDA {

	private javafx.event.EventHandler<javafx.event.ActionEvent> cde;

	public static void main(String[] args) {

		TESTLAMBDA testlambda = new TESTLAMBDA();
		testlambda.cde = ((e) -> System.out.println(e));

	}

}