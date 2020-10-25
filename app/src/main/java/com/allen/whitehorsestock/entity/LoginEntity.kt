package com.allen.whitehorsestock.entity

import android.os.Parcel

import android.os.Parcelable


class LoginEntity {
    private var nextPageToken: String? = null
    private var prevPageToken: String? = null
    private var requestCount = 0
    private var responseCount = 0
    private var totalResults = 0
    private var items: List<ItemsEntity?>? = null

    fun getNextPageToken(): String? {
        return nextPageToken
    }

    fun setNextPageToken(nextPageToken: String?) {
        this.nextPageToken = nextPageToken
    }

    fun getPrevPageToken(): String? {
        return prevPageToken
    }

    fun setPrevPageToken(prevPageToken: String?) {
        this.prevPageToken = prevPageToken
    }

    fun getRequestCount(): Int {
        return requestCount
    }

    fun setRequestCount(requestCount: Int) {
        this.requestCount = requestCount
    }

    fun getResponseCount(): Int {
        return responseCount
    }

    fun setResponseCount(responseCount: Int) {
        this.responseCount = responseCount
    }

    fun getTotalResults(): Int {
        return totalResults
    }

    fun setTotalResults(totalResults: Int) {
        this.totalResults = totalResults
    }

    fun getItems(): List<ItemsEntity?>? {
        return items
    }

    fun setItems(items: List<ItemsEntity?>?) {
        this.items = items
    }

    class ItemsEntity() : Parcelable {
        var detail: String? = null
        var href: String? = null
        var id = 0
        var img: String? = null
        var name: String? = null
        var pubDate: String? = null
        var type = 0

        constructor(parcel: Parcel) : this() {
            detail = parcel.readString()
            href = parcel.readString()
            id = parcel.readInt()
            img = parcel.readString()
            name = parcel.readString()
            pubDate = parcel.readString()
            type = parcel.readInt()
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeString(detail)
            parcel.writeString(href)
            parcel.writeInt(id)
            parcel.writeString(img)
            parcel.writeString(name)
            parcel.writeString(pubDate)
            parcel.writeInt(type)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<ItemsEntity> {
            override fun createFromParcel(parcel: Parcel): ItemsEntity {
                return ItemsEntity(parcel)
            }

            override fun newArray(size: Int): Array<ItemsEntity?> {
                return arrayOfNulls(size)
            }
        }

    }
}