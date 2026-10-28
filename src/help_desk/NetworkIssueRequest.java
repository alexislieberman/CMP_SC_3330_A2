package help_desk;

public class NetworkIssueRequest extends AbstractSupportRequest{

		private final int affectedUsers;

		public NetworkIssueRequest(int id, String title, int basePoints, int affectedUsers) {
			super(id, title, basePoints);
			if (affectedUsers <= 0) {
				throw new IllegalArgumentException("Affected users must be positive");
			}
			this.affectedUsers = affectedUsers;
		}

		public int getAffectedUsers() {
			return affectedUsers;
		}

		/**
		 * Design choice: WEIGHTED rule -> basePoints + (affectedUsers * 2).*/
		@Override
		protected int calculatePoints() {
			return getBasePoints() + (affectedUsers * 2);
		}

		@Override
		public String toString() {
			return super.toString() + " affectedUsers=" + affectedUsers;
		}
	}

