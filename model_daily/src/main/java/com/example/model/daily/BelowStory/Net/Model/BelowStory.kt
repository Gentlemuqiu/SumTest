package com.example.model.daily.BelowStory.Net.Model


import com.google.gson.annotations.SerializedName

data class BelowStory(
    @SerializedName("adExist")
    val adExist: Boolean, // false
    @SerializedName("count")
    val count: Int, // 8
    @SerializedName("itemList")
    val itemList: List<Item>,
    @SerializedName("nextPageUrl")
    val nextPageUrl: String, // http://baobab.kaiyanapp.com/api/v5/index/tab/allRec?page=2&isTag=true&adIndex=3
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
            val actionUrl: String, // eyepetizer://tag/1032/?title=%E7%BB%99%E4%BD%A0%E8%AE%B2%E4%B8%AA%E5%A5%BD%E6%95%85%E4%BA%8B
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
            val category: String, // 剧情
            @SerializedName("collected")
            val collected: Boolean, // false
            @SerializedName("consumption")
            val consumption: Consumption,
            @SerializedName("content")
            val content: Content,
            @SerializedName("cover")
            val cover: Cover,
            @SerializedName("dataType")
            val dataType: String, // TextCard
            @SerializedName("date")
            val date: Long, // 1456416000000
            @SerializedName("description")
            val description: String, // 我为什么要健身？难道真的只是为了减肥吗？短片「如何四步轻松减肥」中，男主角的故事并不只是一个肤浅的减肥励志故事。在健身房里流了一年的汗，不仅是为了外表，也是为了内心。From Benjamin Berman
            @SerializedName("descriptionEditor")
            val descriptionEditor: String, // 我为什么要健身？难道真的只是为了减肥吗？短片「如何四步轻松减肥」中，男主角的故事并不只是一个肤浅的减肥励志故事。在健身房里流了一年的汗，不仅是为了外表，也是为了内心。From Benjamin Berman
            @SerializedName("descriptionPgc")
            val descriptionPgc: Any, // null
            @SerializedName("duration")
            val duration: Int, // 423
            @SerializedName("favoriteAdTrack")
            val favoriteAdTrack: Any, // null
            @SerializedName("follow")
            val follow: Any, // null
            @SerializedName("header")
            val header: Header,
            @SerializedName("id")
            val id: Int, // 0
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
            val playUrl: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=5630&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=
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
            val recallSource: String, @SerializedName("releaseTime")
            val releaseTime: Long, // 1456416000000
            @SerializedName("remark")
            val remark: String,
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
            val text: String, // 给你讲个好故事
            @SerializedName("thumbPlayUrl")
            val thumbPlayUrl: Any, // null
            @SerializedName("title")
            val title: String, // 我为什么要健身？
            @SerializedName("titlePgc")
            val titlePgc: Any, // null
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
        ) {
            data class Author(
                @SerializedName("adTrack")
                val adTrack: Any, // null
                @SerializedName("approvedNotReadyVideoCount")
                val approvedNotReadyVideoCount: Int, // 0
                @SerializedName("description")
                val description: String, // 用一个好故事，描绘生活的不可思议
                @SerializedName("expert")
                val expert: Boolean, // false
                @SerializedName("follow")
                val follow: Follow,
                @SerializedName("icon")
                val icon: String, // http://ali-img.kaiyanapp.com/8581b06aa17c7dbe8970e4c27bbdbd98.png?imageMogr2/quality/60/format/jpg
                @SerializedName("id")
                val id: Int, // 2172
                @SerializedName("ifPgc")
                val ifPgc: Boolean, // true
                @SerializedName("latestReleaseTime")
                val latestReleaseTime: Long, // 1690160423000
                @SerializedName("link")
                val link: String,
                @SerializedName("name")
                val name: String, // 开眼剧情精选
                @SerializedName("recSort")
                val recSort: Int, // 0
                @SerializedName("shield")
                val shield: Shield,
                @SerializedName("videoNum")
                val videoNum: Int // 1189
            ) {
                data class Follow(
                    @SerializedName("followed")
                    val followed: Boolean, // false
                    @SerializedName("itemId")
                    val itemId: Int, // 2172
                    @SerializedName("itemType")
                    val itemType: String // author
                )

                data class Shield(
                    @SerializedName("itemId")
                    val itemId: Int, // 2172
                    @SerializedName("itemType")
                    val itemType: String, // author
                    @SerializedName("shielded")
                    val shielded: Boolean // false
                )
            }

            data class Consumption(
                @SerializedName("collectionCount")
                val collectionCount: Int, // 84911
                @SerializedName("realCollectionCount")
                val realCollectionCount: Int, // 17474
                @SerializedName("replyCount")
                val replyCount: Int, // 563
                @SerializedName("shareCount")
                val shareCount: Int // 76575
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
                    val category: String, // 剧情
                    @SerializedName("collected")
                    val collected: Boolean, // false
                    @SerializedName("consumption")
                    val consumption: Consumption,
                    @SerializedName("cover")
                    val cover: Cover,
                    @SerializedName("dataType")
                    val dataType: String, // VideoBeanForClient
                    @SerializedName("date")
                    val date: Long, // 1457884800000
                    @SerializedName("description")
                    val description: String, // “你相信有灵魂伴侣吗？”女主角躺在床边问了这样一个恋爱中的典型问题。男主角思考了一会，用数学的方式给出了一个现实的答案，其实世界上那么多的人仅仅是能够相遇、认可，就已经是很不容易了。From Art Perez
                    @SerializedName("descriptionEditor")
                    val descriptionEditor: String, // “你相信有灵魂伴侣吗？”女主角躺在床边问了这样一个恋爱中的典型问题。男主角思考了一会，用数学的方式给出了一个现实的答案，其实世界上那么多的人仅仅是能够相遇、认可，就已经是很不容易了。From Art Perez
                    @SerializedName("descriptionPgc")
                    val descriptionPgc: String, // 广州，一个拥有两千多年历史的古老城市，近年来随着经济的腾飞，这个城市也发生了巨大的变化。90后自由摄影师陈子扬深入广州的大街小巷，耗时八个月制作了这段延时摄影作品。From @ch-陳子揚
                    @SerializedName("duration")
                    val duration: Int, // 330
                    @SerializedName("favoriteAdTrack")
                    val favoriteAdTrack: Any, // null
                    @SerializedName("id")
                    val id: Int, // 5544
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
                    val playUrl: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=5544&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=
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
                    val recallSource: String,
                    @SerializedName("releaseTime")
                    val releaseTime: Long, // 1457884800000
                    @SerializedName("remark")
                    val remark: String,
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
                    @SerializedName("subtitles")
                    val subtitles: List<Any>,
                    @SerializedName("tags")
                    val tags: List<Tag>,
                    @SerializedName("thumbPlayUrl")
                    val thumbPlayUrl: Any, // null
                    @SerializedName("title")
                    val title: String, // 你相信有灵魂伴侣吗
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
                    @SerializedName("webUrl")
                    val webUrl: WebUrl
                ) {
                    data class Author(
                        @SerializedName("adTrack")
                        val adTrack: Any, // null
                        @SerializedName("approvedNotReadyVideoCount")
                        val approvedNotReadyVideoCount: Int, // 0
                        @SerializedName("description")
                        val description: String, // 用一个好故事，描绘生活的不可思议
                        @SerializedName("expert")
                        val expert: Boolean, // false
                        @SerializedName("follow")
                        val follow: Follow,
                        @SerializedName("icon")
                        val icon: String, // http://ali-img.kaiyanapp.com/8581b06aa17c7dbe8970e4c27bbdbd98.png?imageMogr2/quality/60/format/jpg
                        @SerializedName("id")
                        val id: Int, // 2172
                        @SerializedName("ifPgc")
                        val ifPgc: Boolean, // true
                        @SerializedName("latestReleaseTime")
                        val latestReleaseTime: Long, // 1690160423000
                        @SerializedName("link")
                        val link: String,
                        @SerializedName("name")
                        val name: String, // 开眼剧情精选
                        @SerializedName("recSort")
                        val recSort: Int, // 0
                        @SerializedName("shield")
                        val shield: Shield,
                        @SerializedName("videoNum")
                        val videoNum: Int // 1189
                    ) {
                        data class Follow(
                            @SerializedName("followed")
                            val followed: Boolean, // false
                            @SerializedName("itemId")
                            val itemId: Int, // 2172
                            @SerializedName("itemType")
                            val itemType: String // author
                        )

                        data class Shield(
                            @SerializedName("itemId")
                            val itemId: Int, // 2172
                            @SerializedName("itemType")
                            val itemType: String, // author
                            @SerializedName("shielded")
                            val shielded: Boolean // false
                        )
                    }

                    data class Consumption(
                        @SerializedName("collectionCount")
                        val collectionCount: Int, // 146744
                        @SerializedName("realCollectionCount")
                        val realCollectionCount: Int, // 26104
                        @SerializedName("replyCount")
                        val replyCount: Int, // 1289
                        @SerializedName("shareCount")
                        val shareCount: Int // 265611
                    )

                    data class Cover(
                        @SerializedName("blurred")
                        val blurred: String, // http://ali-img.kaiyanapp.com/19f7dc4788801e1eedceeb1eed06c128.jpeg?imageMogr2/quality/100
                        @SerializedName("detail")
                        val detail: String, // http://ali-img.kaiyanapp.com/945fa937f0955b31224314a4eeef59b8.jpeg?imageMogr2/quality/100
                        @SerializedName("feed")
                        val feed: String, // http://ali-img.kaiyanapp.com/945fa937f0955b31224314a4eeef59b8.jpeg?imageMogr2/quality/100
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
                        val url: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=5544&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss&udid=
                        @SerializedName("urlList")
                        val urlList: List<Url>,
                        @SerializedName("width")
                        val width: Int // 854
                    ) {
                        data class Url(
                            @SerializedName("name")
                            val name: String, // aliyun
                            @SerializedName("size")
                            val size: Int, // 23988576
                            @SerializedName("url")
                            val url: String // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=5544&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss&udid=
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
                        val actionUrl: String, // eyepetizer://tag/1032/?title=%E7%BB%99%E4%BD%A0%E8%AE%B2%E4%B8%AA%E5%A5%BD%E6%95%85%E4%BA%8B
                        @SerializedName("adTrack")
                        val adTrack: Any, // null
                        @SerializedName("bgPicture")
                        val bgPicture: String, // http://img.kaiyanapp.com/d471080a9de44e8fbaa4850887273332.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("childTagIdList")
                        val childTagIdList: Any, // null
                        @SerializedName("childTagList")
                        val childTagList: Any, // null
                        @SerializedName("communityIndex")
                        val communityIndex: Int, // 0
                        @SerializedName("desc")
                        val desc: String, // 每周末更新，关注听开眼给你讲故事。
                        @SerializedName("haveReward")
                        val haveReward: Boolean, // false
                        @SerializedName("headerImage")
                        val headerImage: String, // http://img.kaiyanapp.com/33a2b832b7583dd9781f9fd40ad7617e.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("id")
                        val id: Int, // 1032
                        @SerializedName("ifNewest")
                        val ifNewest: Boolean, // false
                        @SerializedName("name")
                        val name: String, // 给你讲个好故事
                        @SerializedName("newestEndTime")
                        val newestEndTime: Any, // null
                        @SerializedName("tagRecType")
                        val tagRecType: String // IMPORTANT
                    )

                    data class VideoPosterBean(
                        @SerializedName("fileSizeStr")
                        val fileSizeStr: String, // 2.91MB
                        @SerializedName("scale")
                        val scale: Double, // 0.725
                        @SerializedName("url")
                        val url: String // http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/444ce202daeff95ef75ca2decee175da.mp4
                    )

                    data class WebUrl(
                        @SerializedName("forWeibo")
                        val forWeibo: String, // http://wandou.im/1id5xh
                        @SerializedName("raw")
                        val raw: String // http://www.eyepetizer.net/detail.html?vid=5544
                    )
                }
            }

            data class Cover(
                @SerializedName("blurred")
                val blurred: String, // http://ali-img.kaiyanapp.com/07cbb50d55041eb5e97f5091cac59d64.jpeg?imageMogr2/quality/100
                @SerializedName("detail")
                val detail: String, // http://ali-img.kaiyanapp.com/60a772984b6086faa90fa4f6a8a2412e.jpeg?imageMogr2/quality/100
                @SerializedName("feed")
                val feed: String, // http://ali-img.kaiyanapp.com/60a772984b6086faa90fa4f6a8a2412e.jpeg?imageMogr2/quality/100
                @SerializedName("homepage")
                val homepage: Any, // null
                @SerializedName("sharing")
                val sharing: Any // null
            )

            data class Header(
                @SerializedName("actionUrl")
                val actionUrl: String, // eyepetizer://pgc/detail/2172/?title=%E5%BC%80%E7%9C%BC%E5%89%A7%E6%83%85%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1
                @SerializedName("cover")
                val cover: Any, // null
                @SerializedName("description")
                val description: String, // #剧情 / 收录于 每日编辑精选
                @SerializedName("font")
                val font: Any, // null
                @SerializedName("icon")
                val icon: String, // http://ali-img.kaiyanapp.com/8581b06aa17c7dbe8970e4c27bbdbd98.png?imageMogr2/quality/60/format/jpg
                @SerializedName("iconType")
                val iconType: String, // round
                @SerializedName("id")
                val id: Int, // 5544
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
                val time: Long, // 1457884800000
                @SerializedName("title")
                val title: String // 开眼剧情精选
            )

            data class PlayInfo(
                @SerializedName("height")
                val height: Int, // 480
                @SerializedName("name")
                val name: String, // 标清
                @SerializedName("type")
                val type: String, // normal
                @SerializedName("url")
                val url: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=5630&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss&udid=
                @SerializedName("urlList")
                val urlList: List<Url>,
                @SerializedName("width")
                val width: Int // 854
            ) {
                data class Url(
                    @SerializedName("name")
                    val name: String, // aliyun
                    @SerializedName("size")
                    val size: Int, // 34311481
                    @SerializedName("url")
                    val url: String // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=5630&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss&udid=
                )
            }

            data class Provider(
                @SerializedName("alias")
                val alias: String, // vimeo
                @SerializedName("icon")
                val icon: String, // http://ali-img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png
                @SerializedName("name")
                val name: String // Vimeo
            )

            data class Tag(
                @SerializedName("actionUrl")
                val actionUrl: String, // eyepetizer://tag/1032/?title=%E7%BB%99%E4%BD%A0%E8%AE%B2%E4%B8%AA%E5%A5%BD%E6%95%85%E4%BA%8B
                @SerializedName("adTrack")
                val adTrack: Any, // null
                @SerializedName("bgPicture")
                val bgPicture: String, // http://img.kaiyanapp.com/d471080a9de44e8fbaa4850887273332.jpeg?imageMogr2/quality/60/format/jpg
                @SerializedName("childTagIdList")
                val childTagIdList: Any, // null
                @SerializedName("childTagList")
                val childTagList: Any, // null
                @SerializedName("communityIndex")
                val communityIndex: Int, // 0
                @SerializedName("desc")
                val desc: String, // 每周末更新，关注听开眼给你讲故事。
                @SerializedName("haveReward")
                val haveReward: Boolean, // false
                @SerializedName("headerImage")
                val headerImage: String, // http://img.kaiyanapp.com/33a2b832b7583dd9781f9fd40ad7617e.jpeg?imageMogr2/quality/60/format/jpg
                @SerializedName("id")
                val id: Int, // 1032
                @SerializedName("ifNewest")
                val ifNewest: Boolean, // false
                @SerializedName("name")
                val name: String, // 给你讲个好故事
                @SerializedName("newestEndTime")
                val newestEndTime: Any, // null
                @SerializedName("tagRecType")
                val tagRecType: String // IMPORTANT
            )

            data class VideoPosterBean(
                @SerializedName("fileSizeStr")
                val fileSizeStr: String, // 3.14MB
                @SerializedName("scale")
                val scale: Double, // 0.725
                @SerializedName("url")
                val url: String // http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/76a2b93d7fe3ef7dc32df697d3044415.mp4
            )

            data class WebUrl(
                @SerializedName("forWeibo")
                val forWeibo: String, // http://wandou.im/1jbvwz
                @SerializedName("raw")
                val raw: String // http://www.eyepetizer.net/detail.html?vid=5630
            )
        }
    }
}