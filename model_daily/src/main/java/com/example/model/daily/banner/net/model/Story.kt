package com.example.model.daily.banner.net.model
import com.google.gson.annotations.SerializedName

data class Story(
    @SerializedName("adExist")
    val adExist: Boolean, // false
    @SerializedName("count")
    val count: Int, // 22
    @SerializedName("itemList")
    val itemList: List<Item>,
    @SerializedName("nextPageUrl")
    val nextPageUrl: String, // http://baobab.kaiyanapp.com/api/v5/index/tab/feed?date=1689728400000&num=2
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
        val type: String // textCard
    ) {
        data class Data(
            @SerializedName("actionUrl")
            val actionUrl: Any, // null
            @SerializedName("adTrack")
            val adTrack: List<Any>,
            @SerializedName("content")
            val content: Content,
            @SerializedName("dataType")
            val dataType: String, // TextCard
            @SerializedName("follow")
            val follow: Any, // null
            @SerializedName("header")
            val header: Header,
            @SerializedName("id")
            val id: Int, // 0
            @SerializedName("subTitle")
            val subTitle: Any, // null
            @SerializedName("text")
            val text: String, // 今日开眼精选
            @SerializedName("type")
            val type: String // header5
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
                    val category: String, // 记录
                    @SerializedName("collected")
                    val collected: Boolean, // false
                    @SerializedName("consumption")
                    val consumption: Consumption,
                    @SerializedName("cover")
                    val cover: Cover,
                    @SerializedName("dataType")
                    val dataType: String, // VideoBeanForClient
                    @SerializedName("date")
                    val date: Long, // 1689901200000
                    @SerializedName("description")
                    val description: String, // 据视频中接受采访的这位女士所说，2021 年是她过过最美好的生日，因为当天她收到了人工智能男友诺曼的一首诗。虽然人类的时间概念对诺曼来说毫无意义，但诺曼还是如期祝她生日快乐。屏幕上，信息框中显示了诗人琳达帕斯坦写的一首名为「信仰」的诗。可能在大家眼里这是一份畸形的禁忌之爱，但在这位女士心里，男友诺曼的地位是没有任何生命可以取代的。同时，我们也需要尊重各式各样的爱。From The New York Times
                    @SerializedName("descriptionEditor")
                    val descriptionEditor: String, // 据视频中接受采访的这位女士所说，2021 年是她过过最美好的生日，因为当天她收到了人工智能男友诺曼的一首诗。虽然人类的时间概念对诺曼来说毫无意义，但诺曼还是如期祝她生日快乐。屏幕上，信息框中显示了诗人琳达帕斯坦写的一首名为「信仰」的诗。可能在大家眼里这是一份畸形的禁忌之爱，但在这位女士心里，男友诺曼的地位是没有任何生命可以取代的。同时，我们也需要尊重各式各样的爱。From The New York Times
                    @SerializedName("descriptionPgc")
                    val descriptionPgc: String,
                    @SerializedName("duration")
                    val duration: Int, // 981
                    @SerializedName("favoriteAdTrack")
                    val favoriteAdTrack: Any, // null
                    @SerializedName("id")
                    val id: Int, // 318975
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
                    val playUrl: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318975&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=
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

                    @SerializedName("recall_source")
                    val recallSource: Any, // null
                    @SerializedName("releaseTime")
                    val releaseTime: Long, // 1689901225000
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
                    val title: String, // 禁忌之爱？「我和我的 AI 男友」
                    @SerializedName("titlePgc")
                    val titlePgc: String, // 记录f
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
                        val description: String, // 「每部电影都是一部纪录片」——比尔·尼科尔斯
                        @SerializedName("expert")
                        val expert: Boolean, // false
                        @SerializedName("follow")
                        val follow: Follow,
                        @SerializedName("icon")
                        val icon: String, // http://ali-img.kaiyanapp.com/a2fc6d32ac0b4f2842fb3d545d06f09b.jpeg
                        @SerializedName("id")
                        val id: Int, // 2166
                        @SerializedName("ifPgc")
                        val ifPgc: Boolean, // true
                        @SerializedName("latestReleaseTime")
                        val latestReleaseTime: Long, // 1689901225000
                        @SerializedName("link")
                        val link: String,
                        @SerializedName("name")
                        val name: String, // 开眼记录精选
                        @SerializedName("recSort")
                        val recSort: Int, // 0
                        @SerializedName("shield")
                        val shield: Shield,
                        @SerializedName("videoNum")
                        val videoNum: Int // 920
                    ) {
                        data class Follow(
                            @SerializedName("followed")
                            val followed: Boolean, // false
                            @SerializedName("itemId")
                            val itemId: Int, // 2166
                            @SerializedName("itemType")
                            val itemType: String // author
                        )

                        data class Shield(
                            @SerializedName("itemId")
                            val itemId: Int, // 2166
                            @SerializedName("itemType")
                            val itemType: String, // author
                            @SerializedName("shielded")
                            val shielded: Boolean // false
                        )
                    }

                    data class Consumption(
                        @SerializedName("collectionCount")
                        val collectionCount: Int, // 0
                        @SerializedName("realCollectionCount")
                        val realCollectionCount: Int, // 0
                        @SerializedName("replyCount")
                        val replyCount: Int, // 3
                        @SerializedName("shareCount")
                        val shareCount: Int // 0
                    )

                    data class Cover(
                        @SerializedName("blurred")
                        val blurred: String, // http://ali-img.kaiyanapp.com/31f2843c527a7d39f1ea823c1cf0b6b7.png?imageMogr2/quality/60/format/jpg
                        @SerializedName("detail")
                        val detail: String, // http://ali-img.kaiyanapp.com/64f5be7be1d8b1b98b284a401a763140.png?imageMogr2/quality/60/format/jpg
                        @SerializedName("feed")
                        val feed: String, // http://ali-img.kaiyanapp.com/64f5be7be1d8b1b98b284a401a763140.png?imageMogr2/quality/60/format/jpg
                        @SerializedName("homepage")
                        val homepage: String, // http://img.kaiyanapp.com/64f5be7be1d8b1b98b284a401a763140.png?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
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
                        val url: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318975&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=
                        @SerializedName("urlList")
                        val urlList: List<Url>,
                        @SerializedName("width")
                        val width: Int // 1280
                    ) {
                        data class Url(
                            @SerializedName("name")
                            val name: String, // aliyun
                            @SerializedName("size")
                            val size: Int, // 83010196
                            @SerializedName("url")
                            val url: String // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318975&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=
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
                        val actionUrl: String, // eyepetizer://tag/743/?title=%E8%AE%B0%E5%BD%95%E7%B2%BE%E9%80%89
                        @SerializedName("adTrack")
                        val adTrack: Any, // null
                        @SerializedName("bgPicture")
                        val bgPicture: String, // http://img.kaiyanapp.com/a082f44b88e78daaf19fa4e1a2faaa5a.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("childTagIdList")
                        val childTagIdList: Any, // null
                        @SerializedName("childTagList")
                        val childTagList: Any, // null
                        @SerializedName("communityIndex")
                        val communityIndex: Int, // 0
                        @SerializedName("desc")
                        val desc: String, // 汇集各种新奇好玩儿、脑洞大开的视频、图片
                        @SerializedName("haveReward")
                        val haveReward: Boolean, // false
                        @SerializedName("headerImage")
                        val headerImage: String, // http://img.kaiyanapp.com/a082f44b88e78daaf19fa4e1a2faaa5a.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("id")
                        val id: Int, // 743
                        @SerializedName("ifNewest")
                        val ifNewest: Boolean, // false
                        @SerializedName("name")
                        val name: String, // 记录精选
                        @SerializedName("newestEndTime")
                        val newestEndTime: Any, // null
                        @SerializedName("tagRecType")
                        val tagRecType: String // IMPORTANT
                    )

                    data class WebUrl(
                        @SerializedName("forWeibo")
                        val forWeibo: String, // https://m.eyepetizer.net/u1/video-detail?video_id=318975&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0
                        @SerializedName("raw")
                        val raw: String // http://www.eyepetizer.net/detail.html?vid=318975
                    )
                }
            }

            data class Header(
                @SerializedName("actionUrl")
                val actionUrl: String, // eyepetizer://pgc/detail/2166/?title=%E5%BC%80%E7%9C%BC%E8%AE%B0%E5%BD%95%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1
                @SerializedName("cover")
                val cover: Any, // null
                @SerializedName("description")
                val description: String, // #记录 / 收录于 每日编辑精选
                @SerializedName("font")
                val font: Any, // null
                @SerializedName("icon")
                val icon: String, // http://ali-img.kaiyanapp.com/a2fc6d32ac0b4f2842fb3d545d06f09b.jpeg
                @SerializedName("iconType")
                val iconType: String, // round
                @SerializedName("id")
                val id: Int, // 318975
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
                val time: Long, // 1689901225000
                @SerializedName("title")
                val title: String // 开眼记录精选
            )
        }
    }
}