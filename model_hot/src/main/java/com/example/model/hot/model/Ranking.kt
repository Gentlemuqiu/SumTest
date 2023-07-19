package com.example.model.hot.model
import com.google.gson.annotations.SerializedName


data class Ranking(
    @SerializedName("count")
    val count: Int, // 10
    @SerializedName("itemList")
    val itemList: List<Item>,
) {
    data class Item(
        @SerializedName("data")
        val `data`: Data,
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
            val category: String, // 广告
            @SerializedName("collected")
            val collected: Boolean, // false
            @SerializedName("consumption")
            val consumption: Consumption,
            @SerializedName("cover")
            val cover: Cover,
            @SerializedName("dataType")
            val dataType: String, // VideoBeanForClient
            @SerializedName("date")
            val date: Long, // 1460995200000
            @SerializedName("description")
            val description: String, // 这是一套神奇的互帮互助系统：当你和她激情燃烧却没有带安全套时，只需通过这套系统发送你的定位，就会有陌生人以最体面的方式为你解决燃眉之急。人们之间的善意以及体贴都通过这套系统体现出来了呢~From LLLLITL
            @SerializedName("descriptionEditor")
            val descriptionEditor: String, // 这是一套神奇的互帮互助系统：当你和她激情燃烧却没有带安全套时，只需通过这套系统发送你的定位，就会有陌生人以最体面的方式为你解决燃眉之急。人们之间的善意以及体贴都通过这套系统体现出来了呢~From LLLLITL
            @SerializedName("descriptionPgc")
            val descriptionPgc: String, // 广州，一个拥有两千多年历史的古老城市，近年来随着经济的腾飞，这个城市也发生了巨大的变化。90后自由摄影师陈子扬深入广州的大街小巷，耗时八个月制作了这段延时摄影作品。From @ch-陳子揚
            @SerializedName("duration")
            val duration: Int, // 77
            @SerializedName("favoriteAdTrack")
            val favoriteAdTrack: Any, // null
            @SerializedName("id")
            val id: Int, // 6482
            @SerializedName("idx")
            val idx: Int, // 0
            @SerializedName("ifLimitVideo")
            val ifLimitVideo: Boolean, // false
            @SerializedName("label")
            val label: Label,
            @SerializedName("labelList")
            val labelList: List<Label>,
            @SerializedName("lastViewTime")
            val lastViewTime: Any, // null
            @SerializedName("library")
            val library: String, // DAILY
            @SerializedName("playInfo")
            val playInfo: List<PlayInfo>,
            @SerializedName("playUrl")
            val playUrl: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=6482&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=
            @SerializedName("played")
            val played: Boolean, // false
            @SerializedName("playlists")
            val playlists: Any, // null
            @SerializedName("promotion")
            val promotion: Any, // null
            @SerializedName("reallyCollected")
            val reallyCollected: Boolean, // false
            val releaseTime: Long, // 1460995200000
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
            val src: Any, // null
            @SerializedName("subtitles")
            val subtitles: List<Any>,
            @SerializedName("thumbPlayUrl")
            val thumbPlayUrl: Any, // null
            @SerializedName("title")
            val title: String, // 嘿，你的安全套
            @SerializedName("titlePgc")
            val titlePgc: String, // 广州 guangzhou - 延时摄影
            @SerializedName("type")
            val type: String, // NORMAL
            @SerializedName("videoPosterBean")
            val videoPosterBean: VideoPosterBean,
            @SerializedName("waterMarks")
            val waterMarks: Any, // null
            @SerializedName("webAdTrack")
            val webAdTrack: Any, // null

        ) {
            data class Author(
                @SerializedName("adTrack")
                val adTrack: Any, // null
                @SerializedName("approvedNotReadyVideoCount")
                val approvedNotReadyVideoCount: Int, // 0
                @SerializedName("description")
                val description: String, // 我们精选世界最好看的广告，为全世界广告人的精彩创意点赞。
                @SerializedName("expert")
                val expert: Boolean, // false
                @SerializedName("follow")
                val follow: Follow,
                @SerializedName("icon")
                val icon: String, // http://ali-img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg
                @SerializedName("id")
                val id: Int, // 2162
                @SerializedName("ifPgc")
                val ifPgc: Boolean, // true
                @SerializedName("latestReleaseTime")
                val latestReleaseTime: Long, // 1689728420000
                @SerializedName("link")
                val link: String,
                @SerializedName("name")
                val name: String, // 全球广告精选
                @SerializedName("recSort")
                val recSort: Int, // 0
                @SerializedName("shield")
                val shield: Shield,
                @SerializedName("videoNum")
                val videoNum: Int // 2851
            ) {
                data class Follow(
                    @SerializedName("followed")
                    val followed: Boolean, // false
                    @SerializedName("itemId")
                    val itemId: Int, // 2162
                    @SerializedName("itemType")
                    val itemType: String // author
                )

                data class Shield(
                    @SerializedName("itemId")
                    val itemId: Int, // 2162
                    @SerializedName("itemType")
                    val itemType: String, // author
                    @SerializedName("shielded")
                    val shielded: Boolean // false
                )
            }

            data class Consumption(
                @SerializedName("collectionCount")
                val collectionCount: Int, // 56775
                @SerializedName("realCollectionCount")
                val realCollectionCount: Int, // 7405
                @SerializedName("replyCount")
                val replyCount: Int, // 586
                @SerializedName("shareCount")
                val shareCount: Int // 96300
            )

            data class Cover(
                @SerializedName("blurred")
                val blurred: String, // http://ali-img.kaiyanapp.com/d3ad0df9992489946127fe4d3f4dbab9.jpeg?imageMogr2/quality/100
                @SerializedName("detail")
                val detail: String, // http://ali-img.kaiyanapp.com/316ab6196630815bb53fd85198227b0e.jpeg?imageMogr2/quality/100
                @SerializedName("feed")
                val feed: String, // http://ali-img.kaiyanapp.com/316ab6196630815bb53fd85198227b0e.jpeg?imageMogr2/quality/100
                @SerializedName("homepage")
                val homepage: Any, // null
                @SerializedName("sharing")
                val sharing: Any // null
            )

            data class Label(
                @SerializedName("card")
                val card: String, // 360°全景
                @SerializedName("detail")
                val detail: String, // 360°全景
                @SerializedName("text")
                val text: String // 360°全景
            )
            data class PlayInfo(
                @SerializedName("height")
                val height: Int, // 480
                @SerializedName("name")
                val name: String, // 标清
                @SerializedName("type")
                val type: String, // normal
                @SerializedName("url")
                val url: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=6482&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss&udid=
                @SerializedName("urlList")
                val urlList: List<Url>,
                @SerializedName("width")
                val width: Int // 854
            ) {
                data class Url(
                    @SerializedName("name")
                    val name: String, // aliyun
                    @SerializedName("size")
                    val size: Int, // 6300150
                    @SerializedName("url")
                    val url: String // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=6482&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss&udid=
                )
            }
            data class VideoPosterBean(
                @SerializedName("fileSizeStr")
                val fileSizeStr: String, // 2.37MB
                @SerializedName("scale")
                val scale: Double, // 0.725
                @SerializedName("url")
                val url: String // http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/63cd266db11fe14705ef02d21174a893.mp4
            )
        }
    }
}