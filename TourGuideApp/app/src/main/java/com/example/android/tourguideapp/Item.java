package com.example.android.tourguideapp;

public class Item {
    /**
     * String resource ID for the website link
     */
    private int mWebsiteId;

    /**
     * Constant value that represents no image was provided for this item
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Constant value that represents no map was provided for this item
     */
    private static final int NO_MAP_PROVIDED = -1;

    /**
     * string resource ID for the item
     */
    private int googleMap = NO_MAP_PROVIDED;

    /**
     * Image resource ID for the item
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Create a new item object.
     *
     * @param mImageResourceId is the image resource ID for the item
     * @param mWebsiteId       is the string resource Id contain a link for the item
     * @param googleMap        is the string resource ID for the location in the google map
     */
    public Item(int mImageResourceId, int mWebsiteId, int googleMap) {
        setmImageResourceId(mImageResourceId);
        setmWebsiteId(mWebsiteId);
        setGoogleMap(googleMap);
    }

    /**
     * Create a new item object.
     *
     * @param mImageResourceId is the image resource ID for the item
     * @param mWebsiteId       is the string resource Id contain a link for the item
     */
    public Item(int mImageResourceId, int mWebsiteId) {
        setmImageResourceId(mImageResourceId);
        setmWebsiteId(mWebsiteId);
    }

    /**
     * Create a new item object.
     *
     * @param mWebsiteId       is the string resource Id contain a link for the item
     */
    public Item(int mWebsiteId) {
        setmWebsiteId(mWebsiteId);
    }

    public int getGoogleMap() {
        return googleMap;
    }



    /**
     * Returns whether or not there is an image for this item.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Returns whether or not there is an map string for this item.
     */
    public boolean hasMap() {
        return googleMap != NO_MAP_PROVIDED;
    }

    public void setmImageResourceId(int mImageResourceId) {
        this.mImageResourceId = mImageResourceId;
    }

    public void setmWebsiteId(int mWebsiteId) {
        this.mWebsiteId = mWebsiteId;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getWebsiteId() {
        return mWebsiteId;
    }

    public void setGoogleMap(int googleMap) {
        this.googleMap = googleMap;
    }
}
