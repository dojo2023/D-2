package model;
import java.io.Serializable;
public class Remark implements Serializable{
    private int    remarkId;
    private int communityId;
    private String userId;
    private String remarkText;
    private String remarkDate;

        public Remark(int remarkId, int communityId, String userId, String remarkText, String remarkDate) {

		this.remarkId = remarkId;
		this.communityId = communityId;
		this.userId = userId;
		this.remarkText = remarkText;
		this.remarkDate = remarkDate;
		}

		public Remark() {

			this.remarkId =0;
			this.communityId = 0;
			this.userId = "";
			this.remarkText = "";
			this.remarkDate ="";
	}

        public int getRemarkId() {
			return remarkId;
		}

		public void setRemarkId(int remarkId) {
			this.remarkId = remarkId;
		}

         public int getCommunityId() {
			return communityId;
		}

		public void setCommunityId(int communityId) {
			this.communityId = communityId;
		}

         public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

         public String getRemarkText() {
			return remarkText;
		}

		public void setRemarkText(String remarkText) {
			this.remarkText = remarkText;
		}

         public String getRemarkDate() {
			return remarkDate;
		}

		public void setRemarkDate(String remarkDate) {
			this.remarkDate = remarkDate;
		}
}
