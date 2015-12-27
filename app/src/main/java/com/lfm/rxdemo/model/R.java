package com.lfm.rxdemo.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "author",
        "body",
        "coid",
        "copyright",
        "ct",
        "headline",
        "img",
        "img_landscape",
        "img_square",
        "legend",
        "modified_date",
        "nativeAd_SponsorLogoUrl",
        "nativeAd_SponsorText",
        "nativeAd_SponsorUrl",
        "visu_prio",
        "published_date",
        "rubrique",
        "title",
        "url_web",
        "a_lire_aussi"
})
public class R {

    @JsonProperty("author")
    private List<String> author = new ArrayList<String>();
    @JsonProperty("body")
    private String body;
    @JsonProperty("coid")
    private Integer coid;
    @JsonProperty("copyright")
    private String copyright;
    @JsonProperty("ct")
    private String ct;
    @JsonProperty("headline")
    private String headline;
    @JsonProperty("img")
    private String img;
    @JsonProperty("img_landscape")
    private String imgLandscape;
    @JsonProperty("img_square")
    private String imgSquare;
    @JsonProperty("legend")
    private String legend;
    @JsonProperty("modified_date")
    private String modifiedDate;
    @JsonProperty("nativeAd_SponsorLogoUrl")
    private String nativeAdSponsorLogoUrl;
    @JsonProperty("nativeAd_SponsorText")
    private String nativeAdSponsorText;
    @JsonProperty("nativeAd_SponsorUrl")
    private String nativeAdSponsorUrl;
    @JsonProperty("visu_prio")
    private Integer visuPrio;
    @JsonProperty("published_date")
    private String publishedDate;
    @JsonProperty("rubrique")
    private String rubrique;
    @JsonProperty("title")
    private String title;
    @JsonProperty("url_web")
    private String urlWeb;
    @JsonProperty("a_lire_aussi")
    private List<ALireAussi> aLireAussi = new ArrayList<ALireAussi>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * @return The author
     */
    @JsonProperty("author")
    public List<String> getAuthor() {
        return author;
    }

    /**
     * @param author The author
     */
    @JsonProperty("author")
    public void setAuthor(List<String> author) {
        this.author = author;
    }

    /**
     * @return The body
     */
    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    /**
     * @param body The body
     */
    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return The coid
     */
    @JsonProperty("coid")
    public Integer getCoid() {
        return coid;
    }

    /**
     * @param coid The coid
     */
    @JsonProperty("coid")
    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    /**
     * @return The copyright
     */
    @JsonProperty("copyright")
    public String getCopyright() {
        return copyright;
    }

    /**
     * @param copyright The copyright
     */
    @JsonProperty("copyright")
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * @return The ct
     */
    @JsonProperty("ct")
    public String getCt() {
        return ct;
    }

    /**
     * @param ct The ct
     */
    @JsonProperty("ct")
    public void setCt(String ct) {
        this.ct = ct;
    }

    /**
     * @return The headline
     */
    @JsonProperty("headline")
    public String getHeadline() {
        return headline;
    }

    /**
     * @param headline The headline
     */
    @JsonProperty("headline")
    public void setHeadline(String headline) {
        this.headline = headline;
    }

    /**
     * @return The img
     */
    @JsonProperty("img")
    public String getImg() {
        return img;
    }

    /**
     * @param img The img
     */
    @JsonProperty("img")
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * @return The imgLandscape
     */
    @JsonProperty("img_landscape")
    public String getImgLandscape() {
        return imgLandscape;
    }

    /**
     * @param imgLandscape The img_landscape
     */
    @JsonProperty("img_landscape")
    public void setImgLandscape(String imgLandscape) {
        this.imgLandscape = imgLandscape;
    }

    /**
     * @return The imgSquare
     */
    @JsonProperty("img_square")
    public String getImgSquare() {
        return imgSquare;
    }

    /**
     * @param imgSquare The img_square
     */
    @JsonProperty("img_square")
    public void setImgSquare(String imgSquare) {
        this.imgSquare = imgSquare;
    }

    /**
     * @return The legend
     */
    @JsonProperty("legend")
    public String getLegend() {
        return legend;
    }

    /**
     * @param legend The legend
     */
    @JsonProperty("legend")
    public void setLegend(String legend) {
        this.legend = legend;
    }

    /**
     * @return The modifiedDate
     */
    @JsonProperty("modified_date")
    public String getModifiedDate() {
        return modifiedDate;
    }

    /**
     * @param modifiedDate The modified_date
     */
    @JsonProperty("modified_date")
    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * @return The nativeAdSponsorLogoUrl
     */
    @JsonProperty("nativeAd_SponsorLogoUrl")
    public String getNativeAdSponsorLogoUrl() {
        return nativeAdSponsorLogoUrl;
    }

    /**
     * @param nativeAdSponsorLogoUrl The nativeAd_SponsorLogoUrl
     */
    @JsonProperty("nativeAd_SponsorLogoUrl")
    public void setNativeAdSponsorLogoUrl(String nativeAdSponsorLogoUrl) {
        this.nativeAdSponsorLogoUrl = nativeAdSponsorLogoUrl;
    }

    /**
     * @return The nativeAdSponsorText
     */
    @JsonProperty("nativeAd_SponsorText")
    public String getNativeAdSponsorText() {
        return nativeAdSponsorText;
    }

    /**
     * @param nativeAdSponsorText The nativeAd_SponsorText
     */
    @JsonProperty("nativeAd_SponsorText")
    public void setNativeAdSponsorText(String nativeAdSponsorText) {
        this.nativeAdSponsorText = nativeAdSponsorText;
    }

    /**
     * @return The nativeAdSponsorUrl
     */
    @JsonProperty("nativeAd_SponsorUrl")
    public String getNativeAdSponsorUrl() {
        return nativeAdSponsorUrl;
    }

    /**
     * @param nativeAdSponsorUrl The nativeAd_SponsorUrl
     */
    @JsonProperty("nativeAd_SponsorUrl")
    public void setNativeAdSponsorUrl(String nativeAdSponsorUrl) {
        this.nativeAdSponsorUrl = nativeAdSponsorUrl;
    }

    /**
     * @return The visuPrio
     */
    @JsonProperty("visu_prio")
    public Integer getVisuPrio() {
        return visuPrio;
    }

    /**
     * @param visuPrio The visu_prio
     */
    @JsonProperty("visu_prio")
    public void setVisuPrio(Integer visuPrio) {
        this.visuPrio = visuPrio;
    }

    /**
     * @return The publishedDate
     */
    @JsonProperty("published_date")
    public String getPublishedDate() {
        return publishedDate;
    }

    /**
     * @param publishedDate The published_date
     */
    @JsonProperty("published_date")
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    /**
     * @return The rubrique
     */
    @JsonProperty("rubrique")
    public String getRubrique() {
        return rubrique;
    }

    /**
     * @param rubrique The rubrique
     */
    @JsonProperty("rubrique")
    public void setRubrique(String rubrique) {
        this.rubrique = rubrique;
    }

    /**
     * @return The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The urlWeb
     */
    @JsonProperty("url_web")
    public String getUrlWeb() {
        return urlWeb;
    }

    /**
     * @param urlWeb The url_web
     */
    @JsonProperty("url_web")
    public void setUrlWeb(String urlWeb) {
        this.urlWeb = urlWeb;
    }

    /**
     * @return The aLireAussi
     */
    @JsonProperty("a_lire_aussi")
    public List<ALireAussi> getALireAussi() {
        return aLireAussi;
    }

    /**
     * @param aLireAussi The a_lire_aussi
     */
    @JsonProperty("a_lire_aussi")
    public void setALireAussi(List<ALireAussi> aLireAussi) {
        this.aLireAussi = aLireAussi;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}