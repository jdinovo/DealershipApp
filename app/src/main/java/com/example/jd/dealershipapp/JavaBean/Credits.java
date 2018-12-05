package com.example.jd.dealershipapp.JavaBean;

/**
 * @author Chris Dias
 * @date December 4th, 2018
 * @version 1.0
 *
 * The credits class will contain
 * a title and description within a card view.
 * The card view will be a link to the credited source.
 *
 */

public class Credits {

    private String creditsTitle;
    private String creditsLink;
    private String creditsDesc;

    /**
     * @author Chris Dias
     * @date December 4th, 2018
     * @version 1.0
     *
     * Credits Constructor
     */
    public Credits() {

    }

    public Credits(String creditsTitle, String creditsLink, String creditsDesc) {
        this.creditsTitle = creditsTitle;
        this.creditsLink = creditsLink;
        this.creditsDesc = creditsDesc;
    }


    /**
     * @author Chris Dias
     * @date November 8th, 2018
     * @version 1.0
     *
     * Generated getters and setters for the above properties
     *
     */

    public String getCreditsTitle() {
        return creditsTitle;
    }

    public void setCreditsTitle(String creditsTitle) {
        this.creditsTitle = creditsTitle;
    }

    public String getCreditsLink() {
        return creditsLink;
    }

    public void setCreditsLink(String creditsLink) {
        this.creditsLink = creditsLink;
    }

    public String getCreditsDesc() {
        return creditsDesc;
    }

    public void setCreditsDesc(String creditsDesc) {
        this.creditsDesc = creditsDesc;
    }

}