package model;
import java.io.Serializable;
public class Remark implements Serializable{
    private int    remarkId;
    private String communityId;
    private String userId;
    private String remarkText;
    private String remarkDate;

        public Remark(int remarkId, String communityId, String userId, String remarkText, String remarkDate) {
		super();
		this.remarkId = remarkId;
		this.communityId = communityId;
		this.userId = userId;
		this.remarkText = remarkText;
		this.remarkDate = remarkDate;
		}

		public Remark() {
			super();
			this.remarkId =0;
			this.communityId = "";
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

         public String getCommunityId() {
			return communityId;
		}

		public void setCommunityId(String communityId) {
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
