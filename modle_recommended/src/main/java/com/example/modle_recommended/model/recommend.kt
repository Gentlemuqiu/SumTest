package com.example.modle_recommended.model
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class recommend(
    @SerializedName("adExist")
    val adExist: Boolean, // false
    @SerializedName("count")
    val count: Int, // 14
    @SerializedName("itemList")
    val itemList: List<Item>,
    @SerializedName("nextPageUrl")
    val nextPageUrl: String, // http://baobab.kaiyanapp.com/api/v5/index/tab/allRec?page=1&isTag=true&adIndex=5
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
        val type: String // squareCardCollection
    ) {
        data class Data(
            @SerializedName("actionUrl")
            val actionUrl: String, // eyepetizer://tag/44/?title=5%20%E5%88%86%E9%92%9F%E6%96%B0%E7%9F%A5
            @SerializedName("ad")
            val ad: Boolean, // false
            @SerializedName("adTrack")
            val adTrack: List<Any>,
            @SerializedName("author")
            val author: Author,
            @SerializedName("brandWebsiteInfo")
            val brandWebsiteInfo: Any, // null
            @SerializedName("campaign")
            val campaign: Any, // null
            @SerializedName("category")
            val category: String, // 运动
            @SerializedName("collected")
            val collected: Boolean, // false
            @SerializedName("consumption")
            val consumption: Consumption,
            @SerializedName("content")
            val content: Content,
            @SerializedName("count")
            val count: Int, // 10
            @SerializedName("cover")
            val cover: Cover,
            @SerializedName("dataType")
            val dataType: String, // ItemCollection
            @SerializedName("date")
            val date: Long, // 1451102400000
            @SerializedName("description")
            val description: String, // 多亏了现代科技的发展，这些爱作死的人不仅可以将自己的作死实况记录下来，还可以分享给更多的人了。这支混剪视频集合了2015 年那些爱作死、不怕死的大神们的各式精彩花样。From Martin Scoreback
            @SerializedName("descriptionEditor")
            val descriptionEditor: String, // 多亏了现代科技的发展，这些爱作死的人不仅可以将自己的作死实况记录下来，还可以分享给更多的人了。这支混剪视频集合了2015 年那些爱作死、不怕死的大神们的各式精彩花样。From Martin Scoreback
            @SerializedName("descriptionPgc")
            val descriptionPgc: String, // 爬上 650 米高的上海中心大厦
            @SerializedName("duration")
            val duration: Int, // 289
            @SerializedName("favoriteAdTrack")
            val favoriteAdTrack: Any, // null
            @SerializedName("follow")
            val follow: Any, // null
            @SerializedName("footer")
            val footer: Any, // null
            @SerializedName("header")
            val header: Header,
            @SerializedName("id")
            val id: Int, // 0
            @SerializedName("idx")
            val idx: Int, // 0
            @SerializedName("ifLimitVideo")
            val ifLimitVideo: Boolean, // false
            @SerializedName("itemList")
            val itemList: List<Item>,
            @SerializedName("label")
            val label: Any, // null
            @SerializedName("labelList")
            val labelList: List<Any>,
            @SerializedName("lastViewTime")
            val lastViewTime: Any, // null
            @SerializedName("library")
            val library: String, // DAILY
            @SerializedName("playInfo")
            val playInfo: List<PlayInfo>,
            @SerializedName("playUrl")
            val playUrl: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=3284&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=
            @SerializedName("played")
            val played: Boolean, // false
            @SerializedName("playlists")
            val playlists: Any, // null
            @SerializedName("promotion")
            val promotion: Any, // null
            @SerializedName("provider")
            val provider: Provider,
            @SerializedName("reallyCollected")
            val reallyCollected: Boolean, // false
            @SerializedName("recallSource")
            val recallSource: String,
            @SerializedName("recall_source")
            val recall_Source: String,
            @SerializedName("releaseTime")
            val releaseTime: Long, // 1451102400000
            @SerializedName("remark")
            val remark: String, // https://www.xinpianchang.com/a12421641?from=ArticleList
            @SerializedName("resourceType")
            val resourceType: String, // video
            @SerializedName("searchWeight")
            val searchWeight: Int, // 0
            @SerializedName("shareAdTrack")
            val shareAdTrack: Any, // null
            @SerializedName("slogan")
            val slogan: Any, // null
            @SerializedName("src")
            val src: Int, // 7
            @SerializedName("subTitle")
            val subTitle: Any, // null
            @SerializedName("subtitles")
            val subtitles: List<Any>,
            @SerializedName("tags")
            val tags: List<Tag>,
            @SerializedName("text")
            val text: String, // 5 分钟新知
            @SerializedName("thumbPlayUrl")
            val thumbPlayUrl: Any, // null
            @SerializedName("title")
            val title: String, // 2015 最作死的那些人
            @SerializedName("titlePgc")
            val titlePgc: String, // 爬上 650 米高的上海中心大厦
            @SerializedName("type")
            val type: String, // header5
            @SerializedName("videoPosterBean")
            val videoPosterBean: VideoPosterBean,
            @SerializedName("waterMarks")
            val waterMarks: Any, // null
            @SerializedName("webAdTrack")
            val webAdTrack: Any, // null
            @SerializedName("webUrl")
            val webUrl: WebUrl
        ) : Parcelable {
            constructor(parcel: Parcel) : this(
                parcel.readString()!!,
                parcel.readByte() != 0.toByte(),
                TODO("adTrack"),
                TODO("author"),
                TODO("brandWebsiteInfo"),
                TODO("campaign"),
                parcel.readString()!!,
                parcel.readByte() != 0.toByte(),
                TODO("consumption"),
                TODO("content"),
                parcel.readInt(),
                TODO("cover"),
                parcel.readString()!!,
                parcel.readLong(),
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readInt(),
                TODO("favoriteAdTrack"),
                TODO("follow"),
                TODO("footer"),
                TODO("header"),
                parcel.readInt(),
                parcel.readInt(),
                parcel.readByte() != 0.toByte(),
                TODO("itemList"),
                TODO("label"),
                TODO("labelList"),
                TODO("lastViewTime"),
                parcel.readString()!!,
                TODO("playInfo"),
                parcel.readString()!!,
                parcel.readByte() != 0.toByte(),
                TODO("playlists"),
                TODO("promotion"),
                TODO("provider"),
                parcel.readByte() != 0.toByte(),
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readLong(),
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readInt(),
                TODO("shareAdTrack"),
                TODO("slogan"),
                parcel.readInt(),
                TODO("subTitle"),
                TODO("subtitles"),
                TODO("tags"),
                parcel.readString()!!,
                TODO("thumbPlayUrl"),
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readString()!!,
                TODO("videoPosterBean"),
                TODO("waterMarks"),
                TODO("webAdTrack"),
                TODO("webUrl")
            )

            data class Author(
                @SerializedName("adTrack")
                val adTrack: Any, // null
                @SerializedName("approvedNotReadyVideoCount")
                val approvedNotReadyVideoCount: Int, // 0
                @SerializedName("description")
                val description: String, // 开眼运动精选
                @SerializedName("expert")
                val expert: Boolean, // false
                @SerializedName("follow")
                val follow: Follow,
                @SerializedName("icon")
                val icon: String, // http://ali-img.kaiyanapp.com/f2449da39a584c982866b0636bd30c58.png?imageMogr2/quality/60/format/jpg
                @SerializedName("id")
                val id: Int, // 2003
                @SerializedName("ifPgc")
                val ifPgc: Boolean, // true
                @SerializedName("latestReleaseTime")
                val latestReleaseTime: Long, // 1689210021000
                @SerializedName("link")
                val link: String,
                @SerializedName("name")
                val name: String, // 开眼运动精选
                @SerializedName("recSort")
                val recSort: Int, // 0
                @SerializedName("shield")
                val shield: Shield,
                @SerializedName("videoNum")
                val videoNum: Int // 653
            ) {
                data class Follow(
                    @SerializedName("followed")
                    val followed: Boolean, // false
                    @SerializedName("itemId")
                    val itemId: Int, // 2003
                    @SerializedName("itemType")
                    val itemType: String // author
                )

                data class Shield(
                    @SerializedName("itemId")
                    val itemId: Int, // 2003
                    @SerializedName("itemType")
                    val itemType: String, // author
                    @SerializedName("shielded")
                    val shielded: Boolean // false
                )
            }

            data class Consumption(
                @SerializedName("collectionCount")
                val collectionCount: Int, // 46124
                @SerializedName("realCollectionCount")
                val realCollectionCount: Int, // 5936
                @SerializedName("replyCount")
                val replyCount: Int, // 694
                @SerializedName("shareCount")
                val shareCount: Int // 57868
            )

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
                    @SerializedName("ad")
                    val ad: Boolean, // false
                    @SerializedName("adTrack")
                    val adTrack: List<Any>,
                    @SerializedName("author")
                    val author: Author,
                    @SerializedName("brandWebsiteInfo")
                    val brandWebsiteInfo: Any, // null
                    @SerializedName("campaign")
                    val campaign: Any, // null
                    @SerializedName("category")
                    val category: String, // 科技
                    @SerializedName("collected")
                    val collected: Boolean, // false
                    @SerializedName("consumption")
                    val consumption: Consumption,
                    @SerializedName("cover")
                    val cover: Cover,
                    @SerializedName("dataType")
                    val dataType: String, // VideoBeanForClient
                    @SerializedName("date")
                    val date: Long, // 1488162878000
                    @SerializedName("description")
                    val description: String, // 通过行星及恒星的大小对比，能深刻体会到：人类，不太阳系真的太渺小了！所以，你在焦虑些什么呢？From MORN1415
                    @SerializedName("descriptionEditor")
                    val descriptionEditor: String, // 通过行星及恒星的大小对比，能深刻体会到：人类，不太阳系真的太渺小了！所以，你在焦虑些什么呢？From MORN1415
                    @SerializedName("descriptionPgc")
                    val descriptionPgc: String, // 该视频展现了行星及恒星的大小对比！整个画面十分震撼，人类，不太阳系真的太渺小了！
                    @SerializedName("duration")
                    val duration: Int, // 378
                    @SerializedName("favoriteAdTrack")
                    val favoriteAdTrack: Any, // null
                    @SerializedName("id")
                    val id: Int, // 14796
                    @SerializedName("idx")
                    val idx: Int, // 0
                    @SerializedName("ifLimitVideo")
                    val ifLimitVideo: Boolean, // false
                    @SerializedName("label")
                    val label: Any, // null
                    @SerializedName("labelList")
                    val labelList: List<Any>,
                    @SerializedName("lastViewTime")
                    val lastViewTime: Any, // null
                    @SerializedName("library")
                    val library: String, // DAILY
                    @SerializedName("playInfo")
                    val playInfo: List<PlayInfo>,
                    @SerializedName("playUrl")
                    val playUrl: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=
                    @SerializedName("played")
                    val played: Boolean, // false
                    @SerializedName("playlists")
                    val playlists: Any, // null
                    @SerializedName("promotion")
                    val promotion: Any, // null
                    @SerializedName("provider")
                    val provider: Provider,
                    @SerializedName("reallyCollected")
                    val reallyCollected: Boolean, // false
                    @SerializedName("recallSource")
                    val recallSource: String,
                    @SerializedName("recall_source")
                    val recall_Source: String,
                    @SerializedName("releaseTime")
                    val releaseTime: Long, // 1488162878000
                    @SerializedName("remark")
                    val remark: String,
                    @SerializedName("resourceType")
                    val resourceType: String, // video
                    @SerializedName("searchWeight")
                    val searchWeight: Int, // 0
                    @SerializedName("shareAdTrack")
                    val shareAdTrack: Any, // null
                    @SerializedName("slogan")
                    val slogan: String, // 人类不过是尘埃
                    @SerializedName("src")
                    val src: Int, // 7
                    @SerializedName("subtitles")
                    val subtitles: List<Any>,
                    @SerializedName("tags")
                    val tags: List<Tag>,
                    @SerializedName("thumbPlayUrl")
                    val thumbPlayUrl: Any, // null
                    @SerializedName("title")
                    val title: String, // 震撼你的视野：行星及恒星的大小对比
                    @SerializedName("titlePgc")
                    val titlePgc: String, // 震撼你的视野新版行星及恒星的大小对比
                    @SerializedName("type")
                    val type: String, // NORMAL
                    @SerializedName("videoPosterBean")
                    val videoPosterBean: VideoPosterBean,
                    @SerializedName("waterMarks")
                    val waterMarks: Any, // null
                    @SerializedName("webAdTrack")
                    val webAdTrack: Any, // null
                    @SerializedName("webUrl")
                    val webUrl: WebUrl
                ) {
                    data class Author(
                        @SerializedName("adTrack")
                        val adTrack: Any, // null
                        @SerializedName("approvedNotReadyVideoCount")
                        val approvedNotReadyVideoCount: Int, // 0
                        @SerializedName("description")
                        val description: String, // 跟随天文君一起旅行宇宙，探索未知的世界！公众号ID：tianwenyizu
                        @SerializedName("expert")
                        val expert: Boolean, // false
                        @SerializedName("follow")
                        val follow: Follow,
                        @SerializedName("icon")
                        val icon: String, // http://ali-img.kaiyanapp.com/e0ad67901e14cc87c66558869bf6fbf4.png?imageMogr2/quality/60/format/jpg
                        @SerializedName("id")
                        val id: Int, // 400
                        @SerializedName("ifPgc")
                        val ifPgc: Boolean, // true
                        @SerializedName("latestReleaseTime")
                        val latestReleaseTime: Long, // 1649682821000
                        @SerializedName("link")
                        val link: String,
                        @SerializedName("name")
                        val name: String, // 天文一族
                        @SerializedName("recSort")
                        val recSort: Int, // 0
                        @SerializedName("shield")
                        val shield: Shield,
                        @SerializedName("videoNum")
                        val videoNum: Int // 80
                    ) {
                        data class Follow(
                            @SerializedName("followed")
                            val followed: Boolean, // false
                            @SerializedName("itemId")
                            val itemId: Int, // 400
                            @SerializedName("itemType")
                            val itemType: String // author
                        )

                        data class Shield(
                            @SerializedName("itemId")
                            val itemId: Int, // 400
                            @SerializedName("itemType")
                            val itemType: String, // author
                            @SerializedName("shielded")
                            val shielded: Boolean // false
                        )
                    }

                    data class Consumption(
                        @SerializedName("collectionCount")
                        val collectionCount: Int, // 75068
                        @SerializedName("realCollectionCount")
                        val realCollectionCount: Int, // 11645
                        @SerializedName("replyCount")
                        val replyCount: Int, // 1270
                        @SerializedName("shareCount")
                        val shareCount: Int // 104676
                    )

                    data class Cover(
                        @SerializedName("blurred")
                        val blurred: String, // http://ali-img.kaiyanapp.com/cee6447d64899aeba600fc91a2081d7a.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("detail")
                        val detail: String, // http://ali-img.kaiyanapp.com/3586a5420e4803557e221d5ebaeb8d04.png?imageMogr2/quality/60/format/jpg
                        @SerializedName("feed")
                        val feed: String, // http://ali-img.kaiyanapp.com/3586a5420e4803557e221d5ebaeb8d04.png?imageMogr2/quality/60/format/jpg
                        @SerializedName("homepage")
                        val homepage: Any, // null
                        @SerializedName("sharing")
                        val sharing: Any // null
                    )

                    data class PlayInfo(
                        @SerializedName("height")
                        val height: Int, // 480
                        @SerializedName("name")
                        val name: String, // 标清
                        @SerializedName("type")
                        val type: String, // normal
                        @SerializedName("url")
                        val url: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss&udid=
                        @SerializedName("urlList")
                        val urlList: List<Url>,
                        @SerializedName("width")
                        val width: Int // 854
                    ) {
                        data class Url(
                            @SerializedName("name")
                            val name: String, // aliyun
                            @SerializedName("size")
                            val size: Int, // 53442646
                            @SerializedName("url")
                            val url: String // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=14796&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss&udid=
                        )
                    }

                    data class Provider(
                        @SerializedName("alias")
                        val alias: String, // PGC
                        @SerializedName("icon")
                        val icon: String,
                        @SerializedName("name")
                        val name: String // PGC
                    )

                    data class Tag(
                        @SerializedName("actionUrl")
                        val actionUrl: String, // eyepetizer://tag/44/?title=5%20%E5%88%86%E9%92%9F%E6%96%B0%E7%9F%A5
                        @SerializedName("adTrack")
                        val adTrack: Any, // null
                        @SerializedName("bgPicture")
                        val bgPicture: String, // http://img.kaiyanapp.com/f2e7359e81e217782f32cc3d482b3284.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("childTagIdList")
                        val childTagIdList: Any, // null
                        @SerializedName("childTagList")
                        val childTagList: Any, // null
                        @SerializedName("communityIndex")
                        val communityIndex: Int, // 0
                        @SerializedName("desc")
                        val desc: String, // 大千世界，总有你不知道的
                        @SerializedName("haveReward")
                        val haveReward: Boolean, // false
                        @SerializedName("headerImage")
                        val headerImage: String, // http://img.kaiyanapp.com/f2e7359e81e217782f32cc3d482b3284.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("id")
                        val id: Int, // 44
                        @SerializedName("ifNewest")
                        val ifNewest: Boolean, // false
                        @SerializedName("name")
                        val name: String, // 5 分钟新知
                        @SerializedName("newestEndTime")
                        val newestEndTime: Any, // null
                        @SerializedName("tagRecType")
                        val tagRecType: String // IMPORTANT
                    )

                    data class VideoPosterBean(
                        @SerializedName("fileSizeStr")
                        val fileSizeStr: String, // 3.01MB
                        @SerializedName("scale")
                        val scale: Double, // 0.725
                        @SerializedName("url")
                        val url: String // http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/ea137fbaef4800c8b5b1b9b35ba56f93.mp4
                    )

                    data class WebUrl(
                        @SerializedName("forWeibo")
                        val forWeibo: String, // http://wandou.im/3m62x5
                        @SerializedName("raw")
                        val raw: String // http://www.eyepetizer.net/detail.html?vid=14796
                    )
                }
            }

            data class Cover(
                @SerializedName("blurred")
                val blurred: String, // http://ali-img.kaiyanapp.com/10966a7fa0eee98759f050c7f5448628.jpeg?imageMogr2/quality/100
                @SerializedName("detail")
                val detail: String, // http://ali-img.kaiyanapp.com/522d2216b5f8aca639c296d71ac78753.jpeg?imageMogr2/quality/100
                @SerializedName("feed")
                val feed: String, // http://ali-img.kaiyanapp.com/522d2216b5f8aca639c296d71ac78753.jpeg?imageMogr2/quality/100
                @SerializedName("homepage")
                val homepage: String, // http://img.kaiyanapp.com/f061ac06b3f8e6d913c170d53e1e9303.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
                @SerializedName("sharing")
                val sharing: Any // null
            )

            data class Header(
                @SerializedName("actionUrl")
                val actionUrl: String, // eyepetizer://feed?tabIndex=2
                @SerializedName("cover")
                val cover: Any, // null
                @SerializedName("description")
                val description: String, // #科技 / 收录于 每日编辑精选
                @SerializedName("font")
                val font: String, // bigBold
                @SerializedName("icon")
                val icon: String, // http://ali-img.kaiyanapp.com/e0ad67901e14cc87c66558869bf6fbf4.png?imageMogr2/quality/60/format/jpg
                @SerializedName("iconType")
                val iconType: String, // round
                @SerializedName("id")
                val id: Int, // 5
                @SerializedName("label")
                val label: Any, // null
                @SerializedName("labelList")
                val labelList: Any, // null
                @SerializedName("rightText")
                val rightText: String, // 查看往期
                @SerializedName("showHateVideo")
                val showHateVideo: Boolean, // false
                @SerializedName("subTitle")
                val subTitle: String, // SATURDAY, JULY 15
                @SerializedName("subTitleFont")
                val subTitleFont: String, // lobster
                @SerializedName("textAlign")
                val textAlign: String, // left
                @SerializedName("time")
                val time: Long, // 1488162878000
                @SerializedName("title")
                val title: String // 开眼编辑精选
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
                val type: String // followCard
            ) {
                data class Data(
                    @SerializedName("adTrack")
                    val adTrack: List<Any>,
                    @SerializedName("content")
                    val content: Content,
                    @SerializedName("dataType")
                    val dataType: String, // FollowCard
                    @SerializedName("header")
                    val header: Header
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
                            @SerializedName("ad")
                            val ad: Boolean, // false
                            @SerializedName("adTrack")
                            val adTrack: List<Any>,
                            @SerializedName("author")
                            val author: Author,
                            @SerializedName("brandWebsiteInfo")
                            val brandWebsiteInfo: Any, // null
                            @SerializedName("campaign")
                            val campaign: Any, // null
                            @SerializedName("category")
                            val category: String, // 旅行
                            @SerializedName("collected")
                            val collected: Boolean, // false
                            @SerializedName("consumption")
                            val consumption: Consumption,
                            @SerializedName("cover")
                            val cover: Cover,
                            @SerializedName("dataType")
                            val dataType: String, // VideoBeanForClient
                            @SerializedName("date")
                            val date: Long, // 1689382800000
                            @SerializedName("description")
                            val description: String, // 作者在帕瑞纳天文台度过了一个完整的夜晚来延时拍摄美丽的星空，薄薄的云层在明亮的星星上营造出明亮的钻石效果。帕瑞纳天文台是欧洲南方天文台在智利安托法加斯塔以南约 120 千米的帕瑞纳山的观测地，这里海拔 2632 米，距离海岸线约 12 千米，气候干燥，没有灯光干扰，全年中晴夜数量多于 340 个，是世界上最好的天文观测地之一。 From Boris Häußler
                            @SerializedName("descriptionEditor")
                            val descriptionEditor: String, // 作者在帕瑞纳天文台度过了一个完整的夜晚来延时拍摄美丽的星空，薄薄的云层在明亮的星星上营造出明亮的钻石效果。帕瑞纳天文台是欧洲南方天文台在智利安托法加斯塔以南约 120 千米的帕瑞纳山的观测地，这里海拔 2632 米，距离海岸线约 12 千米，气候干燥，没有灯光干扰，全年中晴夜数量多于 340 个，是世界上最好的天文观测地之一。 From Boris Häußler
                            @SerializedName("descriptionPgc")
                            val descriptionPgc: String,
                            @SerializedName("duration")
                            val duration: Int, // 81
                            @SerializedName("favoriteAdTrack")
                            val favoriteAdTrack: Any, // null
                            @SerializedName("id")
                            val id: Int, // 318892
                            @SerializedName("idx")
                            val idx: Int, // 0
                            @SerializedName("ifLimitVideo")
                            val ifLimitVideo: Boolean, // false
                            @SerializedName("label")
                            val label: Any, // null
                            @SerializedName("labelList")
                            val labelList: List<Any>,
                            @SerializedName("lastViewTime")
                            val lastViewTime: Any, // null
                            @SerializedName("library")
                            val library: String, // DAILY
                            @SerializedName("playInfo")
                            val playInfo: List<PlayInfo>,
                            @SerializedName("playUrl")
                            val playUrl: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318892&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=
                            @SerializedName("played")
                            val played: Boolean, // false
                            @SerializedName("playlists")
                            val playlists: Any, // null
                            @SerializedName("promotion")
                            val promotion: Any, // null
                            @SerializedName("provider")
                            val provider: Provider,
                            @SerializedName("reallyCollected")
                            val reallyCollected: Boolean, // false
                            @SerializedName("recallSource")
                            val recallSource: Any, // null
                            @SerializedName("recall_source")
                            val recall_Source: Any, // null
                            @SerializedName("releaseTime")
                            val releaseTime: Long, // 1689382801000
                            @SerializedName("remark")
                            val remark: String,
                            @SerializedName("resourceType")
                            val resourceType: String, // video
                            @SerializedName("searchWeight")
                            val searchWeight: Int, // 0
                            @SerializedName("shareAdTrack")
                            val shareAdTrack: Any, // null
                            @SerializedName("slogan")
                            val slogan: String,
                            @SerializedName("src")
                            val src: Any, // null
                            @SerializedName("subtitles")
                            val subtitles: List<Any>,
                            @SerializedName("tags")
                            val tags: List<Tag>,
                            @SerializedName("thumbPlayUrl")
                            val thumbPlayUrl: String,
                            @SerializedName("title")
                            val title: String, // 璀璨「星空」之下，漫天萤火飞舞
                            @SerializedName("titlePgc")
                            val titlePgc: String,
                            @SerializedName("type")
                            val type: String, // NORMAL
                            @SerializedName("videoPosterBean")
                            val videoPosterBean: Any, // null
                            @SerializedName("waterMarks")
                            val waterMarks: Any, // null
                            @SerializedName("webAdTrack")
                            val webAdTrack: Any, // null
                            @SerializedName("webUrl")
                            val webUrl: WebUrl
                        ) {
                            data class Author(
                                @SerializedName("adTrack")
                                val adTrack: Any, // null
                                @SerializedName("approvedNotReadyVideoCount")
                                val approvedNotReadyVideoCount: Int, // 0
                                @SerializedName("description")
                                val description: String, // 在这个世界上的很多地方都有着美丽的景色，我们用相机用镜头记录下这一切。
                                @SerializedName("expert")
                                val expert: Boolean, // false
                                @SerializedName("follow")
                                val follow: Follow,
                                @SerializedName("icon")
                                val icon: String, // http://ali-img.kaiyanapp.com/385d659e77af15fa4be37fe638c75917.jpeg?imageMogr2/quality/60/format/jpg
                                @SerializedName("id")
                                val id: Int, // 1313
                                @SerializedName("ifPgc")
                                val ifPgc: Boolean, // true
                                @SerializedName("latestReleaseTime")
                                val latestReleaseTime: Long, // 1689382801000
                                @SerializedName("link")
                                val link: String,
                                @SerializedName("name")
                                val name: String, // 全球旅行视频精选
                                @SerializedName("recSort")
                                val recSort: Int, // 0
                                @SerializedName("shield")
                                val shield: Shield,
                                @SerializedName("videoNum")
                                val videoNum: Int // 2780
                            ) {
                                data class Follow(
                                    @SerializedName("followed")
                                    val followed: Boolean, // false
                                    @SerializedName("itemId")
                                    val itemId: Int, // 1313
                                    @SerializedName("itemType")
                                    val itemType: String // author
                                )

                                data class Shield(
                                    @SerializedName("itemId")
                                    val itemId: Int, // 1313
                                    @SerializedName("itemType")
                                    val itemType: String, // author
                                    @SerializedName("shielded")
                                    val shielded: Boolean // false
                                )
                            }

                            data class Consumption(
                                @SerializedName("collectionCount")
                                val collectionCount: Int, // 155
                                @SerializedName("realCollectionCount")
                                val realCollectionCount: Int, // 87
                                @SerializedName("replyCount")
                                val replyCount: Int, // 8
                                @SerializedName("shareCount")
                                val shareCount: Int // 52
                            )

                            data class Cover(
                                @SerializedName("blurred")
                                val blurred: String, // http://ali-img.kaiyanapp.com/9bafdacb6a84c6ebad103e40f0f01436.jpeg?imageMogr2/quality/60/format/jpg
                                @SerializedName("detail")
                                val detail: String, // http://ali-img.kaiyanapp.com/c538f8e11c2b8a1cf59bbbc94b5be272.jpeg?imageMogr2/quality/60/format/jpg
                                @SerializedName("feed")
                                val feed: String, // http://ali-img.kaiyanapp.com/c538f8e11c2b8a1cf59bbbc94b5be272.jpeg?imageMogr2/quality/60/format/jpg
                                @SerializedName("homepage")
                                val homepage: String, // http://img.kaiyanapp.com/c538f8e11c2b8a1cf59bbbc94b5be272.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
                                @SerializedName("sharing")
                                val sharing: Any // null
                            )

                            data class PlayInfo(
                                @SerializedName("height")
                                val height: Int, // 720
                                @SerializedName("name")
                                val name: String, // 高清
                                @SerializedName("type")
                                val type: String, // high
                                @SerializedName("url")
                                val url: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318963&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=
                                @SerializedName("urlList")
                                val urlList: List<Url>,
                                @SerializedName("width")
                                val width: Int // 1280
                            ) {
                                data class Url(
                                    @SerializedName("name")
                                    val name: String, // aliyun
                                    @SerializedName("size")
                                    val size: Int, // 2299222
                                    @SerializedName("url")
                                    val url: String // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318963&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=
                                )
                            }

                            data class Provider(
                                @SerializedName("alias")
                                val alias: String, // youtube
                                @SerializedName("icon")
                                val icon: String, // http://ali-img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png
                                @SerializedName("name")
                                val name: String // YouTube
                            )

                            data class Tag(
                                @SerializedName("actionUrl")
                                val actionUrl: String, // eyepetizer://tag/10/?title=%E8%B7%9F%E7%9D%80%E5%BC%80%E7%9C%BC%E7%9C%8B%E4%B8%96%E7%95%8C
                                @SerializedName("adTrack")
                                val adTrack: Any, // null
                                @SerializedName("bgPicture")
                                val bgPicture: String, // http://img.kaiyanapp.com/7ea328a893aa1f092b9328a53494a267.png?imageMogr2/quality/60/format/jpg
                                @SerializedName("childTagIdList")
                                val childTagIdList: Any, // null
                                @SerializedName("childTagList")
                                val childTagList: Any, // null
                                @SerializedName("communityIndex")
                                val communityIndex: Int, // 14
                                @SerializedName("desc")
                                val desc: String, // 去你想去的地方，发现世界的美
                                @SerializedName("haveReward")
                                val haveReward: Boolean, // false
                                @SerializedName("headerImage")
                                val headerImage: String, // http://img.kaiyanapp.com/50dab5468ecd2dbe5eb99dab5d608a0a.jpeg?imageMogr2/quality/60/format/jpg
                                @SerializedName("id")
                                val id: Int, // 10
                                @SerializedName("ifNewest")
                                val ifNewest: Boolean, // false
                                @SerializedName("name")
                                val name: String, // 跟着开眼看世界
                                @SerializedName("newestEndTime")
                                val newestEndTime: Any, // null
                                @SerializedName("tagRecType")
                                val tagRecType: String // IMPORTANT
                            )

                            data class WebUrl(
                                @SerializedName("forWeibo")
                                val forWeibo: String, // https://m.eyepetizer.net/u1/video-detail?video_id=318892&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0
                                @SerializedName("raw")
                                val raw: String // http://www.eyepetizer.net/detail.html?vid=318892
                            )
                        }
                    }

                    data class Header(
                        @SerializedName("actionUrl")
                        val actionUrl: String, // eyepetizer://pgc/detail/1313/?title=%E5%85%A8%E7%90%83%E6%97%85%E8%A1%8C%E8%A7%86%E9%A2%91%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1
                        @SerializedName("cover")
                        val cover: Any, // null
                        @SerializedName("description")
                        val description: String,
                        @SerializedName("font")
                        val font: Any, // null
                        @SerializedName("icon")
                        val icon: String, // http://ali-img.kaiyanapp.com/385d659e77af15fa4be37fe638c75917.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("iconType")
                        val iconType: String, // round
                        @SerializedName("id")
                        val id: Int, // 318892
                        @SerializedName("label")
                        val label: Any, // null
                        @SerializedName("labelList")
                        val labelList: Any, // null
                        @SerializedName("rightText")
                        val rightText: Any, // null
                        @SerializedName("showHateVideo")
                        val showHateVideo: Boolean, // false
                        @SerializedName("subTitle")
                        val subTitle: Any, // null
                        @SerializedName("subTitleFont")
                        val subTitleFont: Any, // null
                        @SerializedName("textAlign")
                        val textAlign: String, // left
                        @SerializedName("time")
                        val time: Long, // 1689382801000
                        @SerializedName("title")
                        val title: String // 璀璨「星空」之下，漫天萤火飞舞
                    )
                }
            }

            data class PlayInfo(
                @SerializedName("height")
                val height: Int, // 720
                @SerializedName("name")
                val name: String, // 高清
                @SerializedName("type")
                val type: String, // high
                @SerializedName("url")
                val url: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=3284&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=
                @SerializedName("urlList")
                val urlList: List<Url>,
                @SerializedName("width")
                val width: Int // 1280
            ) {
                data class Url(
                    @SerializedName("name")
                    val name: String, // aliyun
                    @SerializedName("size")
                    val size: Int, // 77262598
                    @SerializedName("url")
                    val url: String // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=3284&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=
                )
            }

            data class Provider(
                @SerializedName("alias")
                val alias: String, // youtube
                @SerializedName("icon")
                val icon: String, // http://ali-img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png
                @SerializedName("name")
                val name: String // YouTube
            )

            data class Tag(
                @SerializedName("actionUrl")
                val actionUrl: String, // eyepetizer://tag/44/?title=5%20%E5%88%86%E9%92%9F%E6%96%B0%E7%9F%A5
                @SerializedName("adTrack")
                val adTrack: Any, // null
                @SerializedName("bgPicture")
                val bgPicture: String, // http://img.kaiyanapp.com/f2e7359e81e217782f32cc3d482b3284.jpeg?imageMogr2/quality/60/format/jpg
                @SerializedName("childTagIdList")
                val childTagIdList: Any, // null
                @SerializedName("childTagList")
                val childTagList: Any, // null
                @SerializedName("communityIndex")
                val communityIndex: Int, // 0
                @SerializedName("desc")
                val desc: String, // 大千世界，总有你不知道的
                @SerializedName("haveReward")
                val haveReward: Boolean, // false
                @SerializedName("headerImage")
                val headerImage: String, // http://img.kaiyanapp.com/f2e7359e81e217782f32cc3d482b3284.jpeg?imageMogr2/quality/60/format/jpg
                @SerializedName("id")
                val id: Int, // 44
                @SerializedName("ifNewest")
                val ifNewest: Boolean, // false
                @SerializedName("name")
                val name: String, // 5 分钟新知
                @SerializedName("newestEndTime")
                val newestEndTime: Any, // null
                @SerializedName("tagRecType")
                val tagRecType: String // IMPORTANT
            )

            data class VideoPosterBean(
                @SerializedName("fileSizeStr")
                val fileSizeStr: String, // 6.04MB
                @SerializedName("scale")
                val scale: Double, // 0.725
                @SerializedName("url")
                val url: String // http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/887ab12377e87ee5a192bd133405d29b.mp4
            )

            data class WebUrl(
                @SerializedName("forWeibo")
                val forWeibo: String, // http://wandou.im/vpibb
                @SerializedName("raw")
                val raw: String // http://www.eyepetizer.net/detail.html?vid=3284
            )

            override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(actionUrl)
                parcel.writeByte(if (ad) 1 else 0)
                parcel.writeString(category)
                parcel.writeByte(if (collected) 1 else 0)
                parcel.writeInt(count)
                parcel.writeString(dataType)
                parcel.writeLong(date)
                parcel.writeString(description)
                parcel.writeString(descriptionEditor)
                parcel.writeString(descriptionPgc)
                parcel.writeInt(duration)
                parcel.writeInt(id)
                parcel.writeInt(idx)
                parcel.writeByte(if (ifLimitVideo) 1 else 0)
                parcel.writeString(library)
                parcel.writeString(playUrl)
                parcel.writeByte(if (played) 1 else 0)
                parcel.writeByte(if (reallyCollected) 1 else 0)
                parcel.writeString(recallSource)
                parcel.writeString(recallSource)
                parcel.writeLong(releaseTime)
                parcel.writeString(remark)
                parcel.writeString(resourceType)
                parcel.writeInt(searchWeight)
                parcel.writeInt(src)
                parcel.writeString(text)
                parcel.writeString(title)
                parcel.writeString(titlePgc)
                parcel.writeString(type)
            }

            override fun describeContents(): Int {
                return 0
            }

            companion object CREATOR : Parcelable.Creator<Data> {
                override fun createFromParcel(parcel: Parcel): Data {
                    return Data(parcel)
                }

                override fun newArray(size: Int): Array<Data?> {
                    return arrayOfNulls(size)
                }
            }
        }
    }
}