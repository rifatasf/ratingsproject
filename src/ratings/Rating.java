package ratings;

public class Rating {
    private String ReviewerID;
    private int rating;
    public Rating(String ReviewerID, int rating) {
        this.ReviewerID = ReviewerID;
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        } else {
            this.rating = -1;
        }
    }
    public String getReviewerID() {
        return this.ReviewerID;
    }

    public void setReviewerID(String reviewerID) {
        this.ReviewerID = reviewerID;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        if (rating >= 1 && rating <= 5) {
            this.rating = rating;
        } else {
            this.rating = -1;
        }
    }
}
