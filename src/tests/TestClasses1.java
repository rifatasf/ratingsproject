package tests;

import org.junit.Test;
import ratings.Rating;
import ratings.Reviewer;
import ratings.Song;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestClasses1 {
    public static boolean compareSongs(Song song1, Song song2) {
        return song1.getTitle().equals(song2.getTitle()) &&
                song1.getArtist().equals(song2.getArtist()) &&
                song1.getSongID().equals(song2.getSongID());
    }


    public static boolean compareRatings(Rating rating1, Rating rating2) {
        return rating1.getRating() == rating2.getRating() &&
                rating1.getReviewerID().equals(rating2.getReviewerID());
    }

    public static boolean compareReviewers(Reviewer rev1, Reviewer rev2) {
        assertEquals("Reviewers IDs are not equal", rev1.getReviewerID(), rev2.getReviewerID());
        return true;
    }

    @Test
    public void testCompareSongs() {
        Song song1 = new Song("Ghost", "Justin Bieber", "123");
        Song song2 = new Song("Ghost", "Justin Bieber", "123");

        assertTrue(compareSongs(song1, song2));
    }

    @Test
    public void testSongSetters() {
        Song oldsong = new Song("Kesariya", "Arijit Singh", "1234");
        oldsong.setTitle("What Do you Mean?");
        oldsong.setArtist("Justin Beiber");
        oldsong.setSongID("2016");

        assertEquals("What Do you Mean?", oldsong.getTitle());
        assertEquals("Justin Beiber", oldsong.getArtist());
        assertEquals("2016", oldsong.getSongID());
    }

    @Test
    public void testCompareRatings() {
        Rating rating1 = new Rating("50515355", 5);
        Rating rating2 = new Rating("50515355", 5);

        assertTrue(compareRatings(rating1, rating2));
    }

    @Test

    public void testRatingsSetters(){
        Rating rating = new Rating("7163060335", 4);
        rating.setReviewerID("7162754693");
        assertEquals("7162754693", rating.getReviewerID());
        Rating validrating = new Rating("9173690710", 3);
        rating.setRating(5);
        assertEquals(5, rating.getRating());
        Rating invalidrating = new Rating("9173690710", 2);
        rating.setRating(8);
        assertEquals(-1, rating.getRating());
        Rating invalrating = new Rating("123", 4);
        invalrating.setRating(0); // Below range
        assertEquals(-1, rating.getRating());
        invalidrating.setRating(6); // Above range
        assertEquals(-1, rating.getRating());
    }

    @Test

    public void testRatingConstructor() {
        Rating invalidRating = new Rating("123", 0);
        assertEquals(-1, invalidRating.getRating());
    }

    @Test

    public void testReviewerRating() {
        Reviewer reviewer = new Reviewer("ButterBlock");
        Rating rating = reviewer.rateSong(4);
        assertEquals(4, rating.getRating());
        assertEquals("ButterBlock", rating.getReviewerID());
    }

    @Test
    public void testCompareReviewers() {
        Reviewer rev1 = new Reviewer("rifatasf");
        Reviewer rev2 = new Reviewer("rifatasf");

        compareReviewers(rev1, rev2);
    }

    @Test

    public void testReviwerSetters() {
        Reviewer reviewerID = new Reviewer("1234567");
        reviewerID.setReviewerID("7654321");
        assertEquals("7654321", reviewerID.getReviewerID());
    }

    @Test

    public void testRateSongWithInvalidRating() {
        Reviewer reviewer = new Reviewer("123");
        Rating ratingBelowRange = reviewer.rateSong(0);
        assertEquals(-1, ratingBelowRange.getRating());
        Rating ratingAboveRange = reviewer.rateSong(6);
        assertEquals(-1, ratingAboveRange.getRating());
    }
}

