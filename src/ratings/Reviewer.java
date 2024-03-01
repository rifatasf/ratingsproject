package ratings;

public class Reviewer {
    private String ReviewerID;

    public Reviewer(String ReviewerID) {
        this.ReviewerID = ReviewerID;
    }

    public String getReviewerID() {
        return ReviewerID;
    }

    public void setReviewerID(String ReviewerID) {
        this.ReviewerID = ReviewerID;
    }

    public Rating rateSong(int rating) {
        if (rating >= 1 && rating <= 5) {
            return new Rating(this.ReviewerID, rating);
        } else {
            return new Rating(this.ReviewerID, -1);
        }
    }
}