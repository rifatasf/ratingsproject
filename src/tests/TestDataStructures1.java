package tests;

import org.junit.Test;
import ratings.Rating;
import ratings.Song;
import ratings.Reviewer;
import ratings.datastructures.LinkedListNode;

import static org.junit.Assert.*;


public class TestDataStructures1 {

    public static boolean compareListsOfRatings(LinkedListNode<Rating> list1, LinkedListNode<Rating> list2) {
        if (list1 == null && list2 == null) {
            return true;
        }
        if (list1 == null || list2 == null) {
            return false;
        }
        Rating rating1 = list1.getData();
        Rating rating2 = list2.getData();
        if (rating1 == null || rating2 == null) {
            return false;
        }
        if (rating1.getRating() != rating2.getRating() || !rating1.getReviewerID().equals(rating2.getReviewerID())) {
            return false;
        }
        return compareListsOfRatings(list1.getNext(), list2.getNext());
    }


    @Test
    public void testCompareListsOfRatings() {
        LinkedListNode<Rating> expectedList = new LinkedListNode<>(new Rating("reviewer1", 4));
        expectedList.setNext(new LinkedListNode<>(new Rating("reviewer2", 5)));
        expectedList.getNext().setNext(new LinkedListNode<>(new Rating("reviewer3", 3)));
        LinkedListNode<Rating> actualList = new LinkedListNode<>(new Rating("reviewer1", 4));
        actualList.setNext(new LinkedListNode<>(new Rating("reviewer2", 5)));
        actualList.getNext().setNext(new LinkedListNode<>(new Rating("reviewer3", 3)));
        assertTrue(TestDataStructures1.compareListsOfRatings(expectedList, actualList));
    }

    @Test

    public void testAddRating() {
        Song song = new Song("WDYM", "JB", "1234");
        Rating rating1 = new Rating("50515355", 4);
        Rating rating2 = new Rating("7163060335", 3);
        Rating rating3 = new Rating("7654321", 1000);
        song.addRating(rating1);
        song.addRating(rating2);
        song.addRating(rating3);
        LinkedListNode<Rating> ratings = song.getRatings();
        assertTrue(ratings != null);
    }

    @Test

    public void testLinkedListSetter() {
        Song song = new Song("Off My Face", "JB", "rifatasf");
        LinkedListNode<Rating> ratingslist = new LinkedListNode<>(new Rating("50515355", 4));
        ratingslist.setNext(new LinkedListNode<>(new Rating("7163060335", 3)));
        ratingslist.getNext().setNext(new LinkedListNode<>(new Rating("7654321", 1000)));
        song.setRating(ratingslist);
        LinkedListNode<Rating> changedList = song.getRatings();
        assertEquals(ratingslist, changedList);
    }

    @Test
    public void testAverageRating() {
        Song song = new Song("Ghost", "JB", "1731");
        song.addRating(new Rating("reviewer1", 4));
        song.addRating(new Rating("reviewer2", 5));
        song.addRating(new Rating("reviewer3", 3));
        song.addRating(new Rating("reviewer4", 2));
        song.addRating(new Rating("reviewer5", 1));
        double expectedAverageRating = (double) (4 + 5 + 3 + 2 + 1) / 5; // Expected average: (4+5+3+2+1) / 5 = 3.0
        double actualAverageRating = song.averageRating();
        double delta = 0.001;
        assertEquals(expectedAverageRating, actualAverageRating, delta);
    }

    @Test
    public void testRemoveRatingByReviewer() {
        Song song = new Song("Ghost", "JB", "1731");
        song.addRating(new Rating("reviewer1", 4));
        song.addRating(new Rating("reviewer2", 5));
        song.addRating(new Rating("reviewer1", 3));
        Reviewer reviewer1 = new Reviewer("reviewer1");
        Reviewer reviewer3 = new Reviewer("reviewer3");
        song.removeRatingByReviewer(reviewer1);
    }
}
