package ratings;

import ratings.datastructures.LinkedListNode;

import java.util.ArrayList;

public class Song {
    private String title;
    private String artist;
    private String songID;
    private LinkedListNode<Rating> ratingslist;

    public Song(String title, String artist, String songID) {
        this.title = title;
        this.artist = artist;
        this.songID = songID;
        this.ratingslist = null;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSongID() {
        return this.songID;
    }

    public void setSongID(String songID) {
        this.songID = songID;
    }
    public void addRating(Rating rating) {
        if (rating == null) {
            return;
        }
        LinkedListNode<Rating> newNode = new LinkedListNode<>(rating);
        if (this.ratingslist == null) {
            this.ratingslist = newNode;
        } else {
            this.addRatingHelper(this.ratingslist, newNode);
        }
    }
    private void addRatingHelper(LinkedListNode<Rating> currentNode, LinkedListNode<Rating> newNode) {
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(newNode);
    }
    public LinkedListNode<Rating> getRatings() {
        return this.ratingslist;
    }
    public void setRating(LinkedListNode<Rating> ratingslist) {
        this.ratingslist = ratingslist;
    }
    public double averageRating() {
        ArrayList<Double> average = new ArrayList<>();
        LinkedListNode<Rating> currentNode = ratingslist;
        while (currentNode != null) {
            Rating num = currentNode.getValue();
            if (num != null) {
                double rating = num.getRating();
                average.add(rating);
            }
            currentNode = currentNode.getNext();
        }
        return ProblemSet.average(average);
    }

    public void removeRatingByReviewer(Reviewer reviewer) {
        if (reviewer == null || ratingslist == null) {
            return;
        }

        LinkedListNode<Rating> prevNode = null;
        LinkedListNode<Rating> currentNode = ratingslist;

        while (currentNode != null) {
            Rating rating = currentNode.getValue();
            if (rating != null && rating.getReviewerID().equals(reviewer.getReviewerID())) {
                if (prevNode == null) {
                    ratingslist = currentNode.getNext();
                } else {
                    prevNode.setNext(currentNode.getNext());
                }
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
    }


    //private LinkedListNode<Rating> removeRatingHelper(LinkedListNode<Rating> currentNode, Reviewer reviewer) {
        //if (currentNode == null) {
            //return null;
        //}
        //Rating rating = currentNode.getData();
        //if (rating.getReviewerID().equals(reviewer.getReviewerID())) {
            //return currentNode.getNext();
        //}
        //currentNode.setNext(removeRatingHelper(currentNode.getNext(), reviewer));
        //return currentNode;
    //}
}
