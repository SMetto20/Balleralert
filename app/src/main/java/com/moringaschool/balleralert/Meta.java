
package com.moringaschool.balleralert;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("current_page")
    @Expose
    private Integer currentPage;
    @SerializedName("next_page")
    @Expose
    private Integer nextPage;
    @SerializedName("per_page")
    @Expose
    private Integer perPage;
    @SerializedName("total_count")
    @Expose
    private Integer totalCount;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Meta() {
    }

    /**
     * 
     * @param perPage
     * @param nextPage
     * @param totalPages
     * @param currentPage
     * @param totalCount
     */
    public Meta(Integer totalPages, Integer currentPage, Integer nextPage, Integer perPage, Integer totalCount) {
        super();
        this.totalPages = totalPages;
        this.currentPage = currentPage;
        this.nextPage = nextPage;
        this.perPage = perPage;
        this.totalCount = totalCount;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

}
