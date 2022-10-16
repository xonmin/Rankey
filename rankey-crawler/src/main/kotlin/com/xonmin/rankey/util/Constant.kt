package com.xonmin.rankey.util

object Constant {
    const val GOOGLE_URL = "https://trends.google.co.kr/trends/trendingsearches/daily?geo=KR"

    // crawling elements locate
    const val CRAWL_TARGET_BOX_XPATH = "/html/body/div[3]/div[2]/div/div[2]/div/div[1]/ng-include/div/div/div/div[2]"
    const val CRWAL_TARGET_DATE_XPATH = "/html/body/div[3]/div[2]/div/div[2]/div/div[1]/ng-include/div/div/div/div[2]/div"
    const val CRWAL_TARGET_BLOCKLIST_CLASSNAME = "md-list-block"

    // crawling tag name
    const val TAG_FEED_ITEM = "feed-item"
    const val TAG_DIV = "div"
    const val TAG_NG_INCLUDE = "ng-include"
    const val TAG_SPAN = "span"
    const val TAG_A = "a"

    // crawling class name
    const val CLASS_FEED_ITEM_HEADER = "feed-item-header"
    const val CLASS_DETAILS = "details"
    const val CLASS_DETAILS_WRAPPER = "details-wrapper"
    const val CLASS_DETAILS_TOP = "details-top"
    const val CLASS_DETAILS_BOTTOM = "details-bottom"
    const val CLASS_INDEX = "index"
    const val CLASS_TITLE = "title"
    const val CLASS_SUMMARY_TEXT= "summary-text"
    const val CLASS_SEARCH_COUNT = "search-count"
    const val CLASS_SEARCH_COUNT_TITLE = "search-count-title"

    const val ATTRIBUTE_HREF = "href"

    const val RANKEY_BASE_PACKAGE = "com.xonmin.rankey"
}
