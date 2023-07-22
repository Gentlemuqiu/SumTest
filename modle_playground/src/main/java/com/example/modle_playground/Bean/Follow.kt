package com.example.modle_playground.Bean
import com.google.gson.annotations.SerializedName


data class Follow(
    @SerializedName("adExist")
    val adExist: Boolean, // false
    @SerializedName("count")
    val count: Int, // 4
    @SerializedName("itemList")
    val itemList: List<Item>,
    @SerializedName("lastStartId")
    val lastStartId: Int, // 0
    @SerializedName("nextPageUrl")
    val nextPageUrl: String, // http://baobab.kaiyanapp.com/api/v4/tabs/follow?start=2&num=2&follow=false&startId=0
    @SerializedName("refreshCount")
    val refreshCount: Int, // 0
    @SerializedName("total")
    val total: Int, // 0
    @SerializedName("updateTime")
    val updateTime: Any // null
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
        val type: String // videoCollectionWithBrief
    ) {
        data class Data(
            @SerializedName("adTrack")
            val adTrack: Any, // null
            @SerializedName("count")
            val count: Int, // 5
            @SerializedName("dataType")
            val dataType: String, // ItemCollection
            @SerializedName("footer")
            val footer: Any, // null
            @SerializedName("header")
            val header: Header,
            @SerializedName("itemList")
            val itemList: List<Item>
        ) {
            data class Header(
                @SerializedName("actionUrl")
                val actionUrl: String, // eyepetizer://pgc/detail/1549/?title=%E6%96%B0%E5%8A%A8%E7%94%BB%E7%A4%BE%E5%8C%BA&userType=PGC&tabIndex=1
                @SerializedName("adTrack")
                val adTrack: Any, // null
                @SerializedName("description")
                val description: String, // 我们是一家成立于 2008 年的公益社区，致力于分享传播优秀动画短片，希望可以激励更多的作者和观众，走进另一个五彩缤纷的世界。
                @SerializedName("expert")
                val expert: Boolean, // false
                @SerializedName("follow")
                val follow: Follow,
                @SerializedName("icon")
                val icon: String, // http://ali-img.kaiyanapp.com/886b01f3e4cf0e2b0b10dbf3e2d5cfc4.jpeg?imageMogr2/quality/60/format/jpg
                @SerializedName("iconType")
                val iconType: String, // round
                @SerializedName("id")
                val id: Int, // 1549
                @SerializedName("ifPgc")
                val ifPgc: Boolean, // true
                @SerializedName("ifShowNotificationIcon")
                val ifShowNotificationIcon: Boolean, // false
                @SerializedName("subTitle")
                val subTitle: Any, // null
                @SerializedName("title")
                val title: String, // 新动画社区
                @SerializedName("uid")
                val uid: Int // 0
            ) {
                data class Follow(
                    @SerializedName("followed")
                    val followed: Boolean, // false
                    @SerializedName("itemId")
                    val itemId: Int, // 1549
                    @SerializedName("itemType")
                    val itemType: String // author
                )
            }

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
                    val category: String, // 动画
                    @SerializedName("collected")
                    val collected: Boolean, // false
                    @SerializedName("consumption")
                    val consumption: Consumption,
                    @SerializedName("cover")
                    val cover: Cover,
                    @SerializedName("dataType")
                    val dataType: String, // VideoBeanForClient
                    @SerializedName("date")
                    val date: Long, // 1503050987000
                    @SerializedName("description")
                    val description: String, // 创意黑白动画：Soylent
                    @SerializedName("descriptionEditor")
                    val descriptionEditor: String,
                    @SerializedName("descriptionPgc")
                    val descriptionPgc: String, // 创意黑白动画：Soylent
                    @SerializedName("duration")
                    val duration: Int, // 73
                    @SerializedName("favoriteAdTrack")
                    val favoriteAdTrack: Any, // null
                    @SerializedName("id")
                    val id: Int, // 44758
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
                    val library: String, // NOT_RECOMMEND
                    @SerializedName("playInfo")
                    val playInfo: List<PlayInfo>,
                    @SerializedName("playUrl")
                    val playUrl: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=44758&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=
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
                    val releaseTime: Long, // 1503050987000
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
                    val title: String, // 创意黑白动画：Soylent
                    @SerializedName("titlePgc")
                    val titlePgc: String, // 创意黑白动画：Soylent
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
                        val description: String, // 我们是一家成立于 2008 年的公益社区，致力于分享传播优秀动画短片，希望可以激励更多的作者和观众，走进另一个五彩缤纷的世界。
                        @SerializedName("expert")
                        val expert: Boolean, // false
                        @SerializedName("follow")
                        val follow: Follow,
                        @SerializedName("icon")
                        val icon: String, // http://ali-img.kaiyanapp.com/886b01f3e4cf0e2b0b10dbf3e2d5cfc4.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("id")
                        val id: Int, // 1549
                        @SerializedName("ifPgc")
                        val ifPgc: Boolean, // true
                        @SerializedName("latestReleaseTime")
                        val latestReleaseTime: Long, // 1503050987000
                        @SerializedName("link")
                        val link: String,
                        @SerializedName("name")
                        val name: String, // 新动画社区
                        @SerializedName("recSort")
                        val recSort: Int, // 0
                        @SerializedName("shield")
                        val shield: Shield,
                        @SerializedName("videoNum")
                        val videoNum: Int // 20
                    ) {
                        data class Follow(
                            @SerializedName("followed")
                            val followed: Boolean, // false
                            @SerializedName("itemId")
                            val itemId: Int, // 1549
                            @SerializedName("itemType")
                            val itemType: String // author
                        )

                        data class Shield(
                            @SerializedName("itemId")
                            val itemId: Int, // 1549
                            @SerializedName("itemType")
                            val itemType: String, // author
                            @SerializedName("shielded")
                            val shielded: Boolean // false
                        )
                    }

                    data class Consumption(
                        @SerializedName("collectionCount")
                        val collectionCount: Int, // 458
                        @SerializedName("realCollectionCount")
                        val realCollectionCount: Int, // 369
                        @SerializedName("replyCount")
                        val replyCount: Int, // 0
                        @SerializedName("shareCount")
                        val shareCount: Int // 425
                    )

                    data class Cover(
                        @SerializedName("blurred")
                        val blurred: String, // http://ali-img.kaiyanapp.com/9ccb3d048b3d4bc1a205f7fffae53787.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("detail")
                        val detail: String, // http://ali-img.kaiyanapp.com/725038354401540d18608c9834ceb914.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("feed")
                        val feed: String, // http://ali-img.kaiyanapp.com/725038354401540d18608c9834ceb914.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("homepage")
                        val homepage: String, // http://img.kaiyanapp.com/3ffde06f09ea4066fac5f19a61ccfc9f.png?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
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
                        val url: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=44758&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss&udid=
                        @SerializedName("urlList")
                        val urlList: List<Url>,
                        @SerializedName("width")
                        val width: Int // 854
                    ) {
                        data class Url(
                            @SerializedName("name")
                            val name: String, // aliyun
                            @SerializedName("size")
                            val size: Int, // 4261486
                            @SerializedName("url")
                            val url: String // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=44758&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss&udid=
                        )
                    }

                    data class Provider(
                        @SerializedName("alias")
                        val alias: String, // CustomSrc
                        @SerializedName("icon")
                        val icon: String,
                        @SerializedName("name")
                        val name: String // 定制来源
                    )

                    data class Tag(
                        @SerializedName("actionUrl")
                        val actionUrl: String, // eyepetizer://tag/14/?title=%E5%8A%A8%E7%94%BB%E6%A2%A6%E5%B7%A5%E5%8E%82
                        @SerializedName("adTrack")
                        val adTrack: Any, // null
                        @SerializedName("bgPicture")
                        val bgPicture: String, // http://img.kaiyanapp.com/afb9e7d7f061d10ade5ebcb524dc8679.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("childTagIdList")
                        val childTagIdList: Any, // null
                        @SerializedName("childTagList")
                        val childTagList: Any, // null
                        @SerializedName("communityIndex")
                        val communityIndex: Int, // 0
                        @SerializedName("desc")
                        val desc: String, // 有趣的人永远不缺童心
                        @SerializedName("haveReward")
                        val haveReward: Boolean, // false
                        @SerializedName("headerImage")
                        val headerImage: String, // http://img.kaiyanapp.com/f9eae3e0321fa1e99a7b38641b5536a2.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("id")
                        val id: Int, // 14
                        @SerializedName("ifNewest")
                        val ifNewest: Boolean, // false
                        @SerializedName("name")
                        val name: String, // 动画梦工厂
                        @SerializedName("newestEndTime")
                        val newestEndTime: Any, // null
                        @SerializedName("tagRecType")
                        val tagRecType: String // IMPORTANT
                    )

                    data class VideoPosterBean(
                        @SerializedName("fileSizeStr")
                        val fileSizeStr: String, // 1.84MB
                        @SerializedName("scale")
                        val scale: Double, // 0.725
                        @SerializedName("url")
                        val url: String // http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/23017a6913b2b0cea660079059d6efec.mp4
                    )

                    data class WebUrl(
                        @SerializedName("forWeibo")
                        val forWeibo: String, // http://wandou.im/3o58le
                        @SerializedName("raw")
                        val raw: String // http://www.eyepetizer.net/detail.html?vid=44758
                    )
                }
            }
        }
    }
}