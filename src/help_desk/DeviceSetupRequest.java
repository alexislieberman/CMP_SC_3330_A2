package help_desk;

public class DeviceSetupRequest extends AbstractSupportRequest {

	private final int deviceCount;

	public DeviceSetupRequest(int id, String title, int basePoints, int deviceCount) {
		super(id, title, basePoints);
		if (deviceCount <= 0) {
			throw new IllegalArgumentException("Device count must be positive");
		}
		this.deviceCount = deviceCount;
	}

	public int getDeviceCount() {
		return deviceCount;
	}

	@Override
	protected int calculatePoints() {
		return getBasePoints() * deviceCount;
	}

	@Override
	public String toString() {
		return super.toString() + " devices=" + deviceCount;
	}
}

