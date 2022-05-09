package statisticker;

public class IAlerter {
	private EmailAlert alert;
	private LEDAlert ledAlert;

	public IAlerter(EmailAlert alert, LEDAlert ledAlert) {
		super();
		this.alert = alert;
		this.ledAlert = ledAlert;
	}

	public EmailAlert getAlert() {
		return alert;
	}

	public void setAlert(EmailAlert alert) {
		this.alert = alert;
	}

	public LEDAlert getLedAlert() {
		return ledAlert;
	}

	public void setLedAlert(LEDAlert ledAlert) {
		this.ledAlert = ledAlert;
	}

}
