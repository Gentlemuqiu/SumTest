package com.example.modle_playground.Bean
import com.google.gson.annotations.SerializedName


data class RecommendBean(
    @SerializedName("adExist")
    val adExist: Boolean, // false
    @SerializedName("count")
    val count: Int, // 11
    @SerializedName("itemList")
    val itemList: List<Item>,
    @SerializedName("nextPageUrl")
    val nextPageUrl: String, // http://baobab.kaiyanapp.com/api/v7/community/tab/rec?startScore=1661712555000&pageCount=2
    @SerializedName("total")
    val total: Int // 0
) {
    data class Item(
        @SerializedName("adIndex")
        val adIndex: Int, // -1
        @SerializedName("data")
        val `data`: Data,
        @SerializedName("id")
        val id: Int, // 0
        @SerializedName("tag")
        val tag: Any, // null
        @SerializedName("trackingData")
        val trackingData: Any, // null
        @SerializedName("type")
        val type: String // horizontalScrollCard
    ) {
        data class Data(
            @SerializedName("adTrack")
            val adTrack: Any, // null
            @SerializedName("content")
            val content: Content,
            @SerializedName("count")
            val count: Int, // 2
            @SerializedName("dataType")
            val dataType: String, // ItemCollection
            @SerializedName("footer")
            val footer: Any, // null
            @SerializedName("header")
            val header: Header,
            @SerializedName("itemList")
            val itemList: List<Item>
        ) {
            data class Content(
                @SerializedName("adIndex")
                val adIndex: Int, // -1
                @SerializedName("data")
                val `data`: Data,
                @SerializedName("id")
                val id: Int, // 0
                @SerializedName("tag")
                val tag: Any, // null
                @SerializedName("trackingData")
                val trackingData: Any, // null
                @SerializedName("type")
                val type: String // video
            ) {
                data class Data(
                    @SerializedName("addWatermark")
                    val addWatermark: Boolean, // true
                    @SerializedName("area")
                    val area: String, // 成都市
                    @SerializedName("checkStatus")
                    val checkStatus: String, // CHECKED
                    @SerializedName("city")
                    val city: String, // 成都市
                    @SerializedName("collected")
                    val collected: Boolean, // false
                    @SerializedName("consumption")
                    val consumption: Consumption,
                    @SerializedName("cover")
                    val cover: Cover,
                    @SerializedName("createTime")
                    val createTime: Long, // 1661916434000
                    @SerializedName("dataType")
                    val dataType: String, // UgcVideoBean
                    @SerializedName("description")
                    val description: String, // 时隔六年，他的声音，再次唤醒了我们对平凡生活的向往。
                    @SerializedName("duration")
                    val duration: Int, // 99
                    @SerializedName("height")
                    val height: Int, // 1080
                    @SerializedName("id")
                    val id: Int, // 315396
                    @SerializedName("ifMock")
                    val ifMock: Boolean, // false
                    @SerializedName("latitude")
                    val latitude: Double, // 30.5690633
                    @SerializedName("library")
                    val library: String, // DEFAULT
                    @SerializedName("longitude")
                    val longitude: Double, // 104.1779758
                    @SerializedName("owner")
                    val owner: Owner,
                    @SerializedName("playUrl")
                    val playUrl: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=315396&resourceType=ugc_video&editionType=default&source=aliyun&playUrlType=url_oss&udid=
                    @SerializedName("playUrlWatermark")
                    val playUrlWatermark: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=315396&resourceType=ugc_video&editionType=default&source=aliyun&playUrlType=play_url_watermark&udid=
                    @SerializedName("privateMessageActionUrl")
                    val privateMessageActionUrl: Any, // null
                    @SerializedName("reallyCollected")
                    val reallyCollected: Boolean, // false
                    @SerializedName("recentOnceReply")
                    val recentOnceReply: RecentOnceReply,
                    @SerializedName("releaseTime")
                    val releaseTime: Long, // 1661916434000
                    @SerializedName("resourceType")
                    val resourceType: String, // ugc_video
                    @SerializedName("selectedTime")
                    val selectedTime: Any, // null
                    @SerializedName("source")
                    val source: String,
                    @SerializedName("tags")
                    val tags: List<Tag>,
                    @SerializedName("title")
                    val title: String,
                    @SerializedName("transId")
                    val transId: Any, // null
                    @SerializedName("type")
                    val type: String, // COMMON
                    @SerializedName("uid")
                    val uid: Int, // 303343704
                    @SerializedName("updateTime")
                    val updateTime: Long, // 1662480155000
                    @SerializedName("url")
                    val url: String, // http://ali-img.kaiyanapp.com/c41ba8977bbc9f172fb9eb0f360e8aa8.png?imageMogr2/quality/100!/format/jpg
                    @SerializedName("urls")
                    val urls: ArrayList<String>,
                    @SerializedName("urlsWithWatermark")
                    val urlsWithWatermark: List<String>,
                    @SerializedName("validateResult")
                    val validateResult: String, // DEFAULT
                    @SerializedName("validateStatus")
                    val validateStatus: String, // SUBMIT
                    @SerializedName("validateTaskId")
                    val validateTaskId: String, // vi7TDqQqeQ4YZ4Eh9gipw9so-1wL7Mj
                    @SerializedName("width")
                    val width: Int // 1920
                ) {
                    data class Consumption(
                        @SerializedName("collectionCount")
                        val collectionCount: Int, // 63
                        @SerializedName("realCollectionCount")
                        val realCollectionCount: Int, // 5
                        @SerializedName("replyCount")
                        val replyCount: Int, // 0
                        @SerializedName("shareCount")
                        val shareCount: Int // 0
                    )

                    data class Cover(
                        @SerializedName("blurred")
                        val blurred: Any, // null
                        @SerializedName("detail")
                        val detail: String, // http://ali-img.kaiyanapp.com/b91c10d2018fc84b2c7678c23693fc7d.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("feed")
                        val feed: String, // http://ali-img.kaiyanapp.com/b91c10d2018fc84b2c7678c23693fc7d.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("homepage")
                        val homepage: Any, // null
                        @SerializedName("sharing")
                        val sharing: Any // null
                    )

                    data class Owner(
                        @SerializedName("actionUrl")
                        val actionUrl: String, // eyepetizer://pgc/detail/303343704/?title=%E4%B9%8C%E8%8B%8F%E5%B0%91%E5%B9%B4&userType=NORMAL&tabIndex=0
                        @SerializedName("area")
                        val area: Any, // null
                        @SerializedName("avatar")
                        val avatar: String, // http://ali-img.kaiyanapp.com/f7892c6ac9d6e9611cbad07deeef172f.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("birthday")
                        val birthday: Long, // 820857600000
                        @SerializedName("city")
                        val city: String,
                        @SerializedName("country")
                        val country: String,
                        @SerializedName("cover")
                        val cover: String, // http://img.kaiyanapp.com/f9a3fddd3f0941404f4b1d30235c2952.png?imageMogr2/quality/60/format/jpg
                        @SerializedName("description")
                        val description: String, // 陌上花开，缓缓归矣
                        @SerializedName("expert")
                        val expert: Boolean, // false
                        @SerializedName("followed")
                        val followed: Boolean, // false
                        @SerializedName("gender")
                        val gender: String, // male
                        @SerializedName("ifPgc")
                        val ifPgc: Boolean, // false
                        @SerializedName("job")
                        val job: String,
                        @SerializedName("library")
                        val library: String, // BLOCK
                        @SerializedName("limitVideoOpen")
                        val limitVideoOpen: Boolean, // false
                        @SerializedName("nickname")
                        val nickname: String, // 乌苏少年
                        @SerializedName("registDate")
                        val registDate: Long, // 1571538610000
                        @SerializedName("releaseDate")
                        val releaseDate: Long, // 1679324559000
                        @SerializedName("uid")
                        val uid: Int, // 303343704
                        @SerializedName("university")
                        val university: String,
                        @SerializedName("userType")
                        val userType: String // NORMAL
                    )

                    data class RecentOnceReply(
                        @SerializedName("actionUrl")
                        val actionUrl: String, // eyepetizer://pgc/detail/301331974/?title=%E5%8F%AB%E6%88%91%E5%95%A5&userType=NORMAL&tabIndex=0
                        @SerializedName("contentType")
                        val contentType: Any, // null
                        @SerializedName("dataType")
                        val dataType: String, // SimpleHotReplyCard
                        @SerializedName("message")
                        val message: String, // 往往这种就是最吸引人的
                        @SerializedName("nickname")
                        val nickname: String // 叫我啥
                    )

                    data class Tag(
                        @SerializedName("actionUrl")
                        val actionUrl: String, // eyepetizer://tag/1604/?title=%E8%B7%9F%E7%9D%80%E7%94%B5%E5%BD%B1%E5%8E%BB%E6%97%85%E8%A1%8C
                        @SerializedName("adTrack")
                        val adTrack: Any, // null
                        @SerializedName("bgPicture")
                        val bgPicture: String, // http://img.kaiyanapp.com/0c5a833dd888f324ec20458babce2ed0.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("childTagIdList")
                        val childTagIdList: Any, // null
                        @SerializedName("childTagList")
                        val childTagList: Any, // null
                        @SerializedName("communityIndex")
                        val communityIndex: Int, // 2
                        @SerializedName("desc")
                        val desc: String, // 打卡荧幕上的同款风景
                        @SerializedName("haveReward")
                        val haveReward: Boolean, // false
                        @SerializedName("headerImage")
                        val headerImage: String, // http://img.kaiyanapp.com/0c5a833dd888f324ec20458babce2ed0.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("id")
                        val id: Int, // 1604
                        @SerializedName("ifNewest")
                        val ifNewest: Boolean, // false
                        @SerializedName("name")
                        val name: String, // 跟着电影去旅行
                        @SerializedName("newestEndTime")
                        val newestEndTime: Long, // 1587555537000
                        @SerializedName("tagRecType")
                        val tagRecType: String // NORMAL
                    )
                }
            }

            data class Header(
                @SerializedName("actionUrl")
                val actionUrl: String, // eyepetizer://pgc/detail/303343704/?title=%E4%B9%8C%E8%8B%8F%E5%B0%91%E5%B9%B4&userType=NORMAL&tabIndex=0
                @SerializedName("followType")
                val followType: String, // user
                @SerializedName("icon")
                val icon: String, // http://img.kaiyanapp.com/f7892c6ac9d6e9611cbad07deeef172f.jpeg?imageMogr2/quality/60/format/jpg
                @SerializedName("iconType")
                val iconType: String, // round
                @SerializedName("id")
                val id: Int, // 315396
                @SerializedName("issuerName")
                val issuerName: String, // 乌苏少年
                @SerializedName("labelList")
                val labelList: Any, // null
                @SerializedName("showHateVideo")
                val showHateVideo: Boolean, // false
                @SerializedName("tagId")
                val tagId: Int, // 0
                @SerializedName("tagName")
                val tagName: Any, // null
                @SerializedName("time")
                val time: Long, // 1661916434000
                @SerializedName("topShow")
                val topShow: Boolean // false
            )

            data class Item(
                @SerializedName("adIndex")
                val adIndex: Int, // -1
                @SerializedName("data")
                val `data`: Data,
                @SerializedName("id")
                val id: Int, // 0
                @SerializedName("tag")
                val tag: Any, // null
                @SerializedName("trackingData")
                val trackingData: Any, // null
                @SerializedName("type")
                val type: String // squareCardOfCommunityContent
            ) {
                data class Data(
                    @SerializedName("actionUrl")
                    val actionUrl: String, // eyepetizer://community/tagSquare?tabIndex=0
                    @SerializedName("adTrack")
                    val adTrack: List<Any>,
                    @SerializedName("autoPlay")
                    val autoPlay: Boolean, // false
                    @SerializedName("bgPicture")
                    val bgPicture: String, // http://img.kaiyanapp.com/04eef7e9f3b14a597bd04a8d81a4c8f3.png?imageMogr2/quality/60/format/jpg
                    @SerializedName("dataType")
                    val dataType: String, // SquareContentCard
                    @SerializedName("description")
                    val description: String,
                    @SerializedName("header")
                    val header: Header,
                    @SerializedName("id")
                    val id: Int, // 2328
                    @SerializedName("image")
                    val image: String, // http://img.kaiyanapp.com/67ac1d67ae077650d1ef35f2312452dc.jpeg?imageMogr2/quality/60/format/jpg
                    @SerializedName("label")
                    val label: Label,
                    @SerializedName("labelList")
                    val labelList: List<Label>,
                    @SerializedName("shade")
                    val shade: Boolean, // false
                    @SerializedName("subTitle")
                    val subTitle: String, // 发布你的作品和日常
                    @SerializedName("title")
                    val title: String // 主题创作广场
                ) {
                    data class Header(
                        @SerializedName("actionUrl")
                        val actionUrl: Any, // null
                        @SerializedName("cover")
                        val cover: Any, // null
                        @SerializedName("description")
                        val description: Any, // null
                        @SerializedName("font")
                        val font: Any, // null
                        @SerializedName("icon")
                        val icon: Any, // null
                        @SerializedName("id")
                        val id: Int, // 0
                        @SerializedName("label")
                        val label: Any, // null
                        @SerializedName("labelList")
                        val labelList: Any, // null
                        @SerializedName("rightText")
                        val rightText: Any, // null
                        @SerializedName("subTitle")
                        val subTitle: Any, // null
                        @SerializedName("subTitleFont")
                        val subTitleFont: Any, // null
                        @SerializedName("textAlign")
                        val textAlign: String, // left
                        @SerializedName("title")
                        val title: Any // null
                    )

                    data class Label(
                        @SerializedName("card")
                        val card: String,
                        @SerializedName("detail")
                        val detail: Any, // null
                        @SerializedName("text")
                        val text: String
                    )

                }
            }
        }
    }
}