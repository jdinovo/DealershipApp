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
    private String creditsAuthor;
    private String creditsDesc;
    private String creditsLink;

    /**
     * @author Chris Dias
     * @date December 4th, 2018
     * @version 1.0
     *
     * Credits Constructor
     */
    public Credits() {

    }

    public Credits(String creditsTitle, String creditsAuthor, String creditsDesc, String creditsLink) {
        this.creditsTitle = creditsTitle;
        this.creditsAuthor = creditsAuthor;
        this.creditsDesc = creditsDesc;
        this.creditsLink = creditsLink;
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

    public String getCreditsAuthor() {
        return creditsAuthor;
    }

    public void setCreditsAuthor(String creditsAuthor) {
        this.creditsAuthor = creditsAuthor;
    }

    public String getCreditsDesc() {
        return creditsDesc;
    }

    public void setCreditsDesc(String creditsDesc) {
        this.creditsDesc = creditsDesc;
    }

    public String getCreditsLink() {
        return creditsLink;
    }

    public void setCreditsLink(String creditsLink) {
        this.creditsLink = creditsLink;
    }
}