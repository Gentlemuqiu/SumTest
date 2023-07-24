package com.example.model.daily.BelowBanner.net.model


import com.google.gson.annotations.SerializedName

data class BelowStory(
    @SerializedName("adExist")
    val adExist: Boolean, // false
    @SerializedName("count")
    val count: Int, // 8
    @SerializedName("itemList")
    val itemList: List<Item>,
    @SerializedName("nextPageUrl")
    val nextPageUrl: String, // http://baobab.kaiyanapp.com/api/v5/index/tab/allRec?page=4&isTag=true&adIndex=3
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
            val actionUrl: String, // eyepetizer://tag/20/?title=%E9%A3%8E%E5%91%B3%E5%B8%82%E9%9B%86
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
            val category: String, // 开胃
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
            val date: Long, // 1457884800000
            @SerializedName("description")
            val description: String, // 南乳猪手，不仅味美，也是一道检验感情程度的菜肴。当你唆着满手卤汁嘴角黏腻，不论是情侣还是好伙伴，对方看着你那丑样还由衷的开心，那么要恭喜你们之间的感情肯定不一般了。From@日食记
            @SerializedName("descriptionEditor")
            val descriptionEditor: String, // 南乳猪手，不仅味美，也是一道检验感情程度的菜肴。当你唆着满手卤汁嘴角黏腻，不论是情侣还是好伙伴，对方看着你那丑样还由衷的开心，那么要恭喜你们之间的感情肯定不一般了。From@日食记
            @SerializedName("descriptionPgc")
            val descriptionPgc: String,
            @SerializedName("duration")
            val duration: Int, // 189
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
            val playUrl: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=5614&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=
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
            val slogan: String,
            @SerializedName("src")
            val src: Int, // 7
            @SerializedName("subTitle")
            val subTitle: Any, // null
            @SerializedName("subtitles")
            val subtitles: List<Any>,
            @SerializedName("tags")
            val tags: List<Tag>,
            @SerializedName("text")
            val text: String, // 风味市集
            @SerializedName("thumbPlayUrl")
            val thumbPlayUrl: String,
            @SerializedName("title")
            val title: String, // 南乳猪手
            @SerializedName("titlePgc")
            val titlePgc: String,
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
                val description: String, // 治愈你心和胃的日食记：） 快加我的微信公众号【日食记】，否则我就……求求你加我！ 微博 @日食记 @酥饼大人
                @SerializedName("expert")
                val expert: Boolean, // false
                @SerializedName("follow")
                val follow: Follow,
                @SerializedName("icon")
                val icon: String, // http://ali-img.kaiyanapp.com/2faf2139c4b655e56a54bdb2ee06e0b4.jpeg
                @SerializedName("id")
                val id: Int, // 22
                @SerializedName("ifPgc")
                val ifPgc: Boolean, // true
                @SerializedName("latestReleaseTime")
                val latestReleaseTime: Long, // 1681460136000
                @SerializedName("link")
                val link: String, // http://weibo.com/rishiji?from=myfollow_all
                @SerializedName("name")
                val name: String, // 日食记
                @SerializedName("recSort")
                val recSort: Int, // 0
                @SerializedName("shield")
                val shield: Shield,
                @SerializedName("videoNum")
                val videoNum: Int // 436
            ) {
                data class Follow(
                    @SerializedName("followed")
                    val followed: Boolean, // false
                    @SerializedName("itemId")
                    val itemId: Int, // 22
                    @SerializedName("itemType")
                    val itemType: String // author
                )

                data class Shield(
                    @SerializedName("itemId")
                    val itemId: Int, // 22
                    @SerializedName("itemType")
                    val itemType: String, // author
                    @SerializedName("shielded")
                    val shielded: Boolean // false
                )
            }

            data class Consumption(
                @SerializedName("collectionCount")
                val collectionCount: Int, // 28330
                @SerializedName("realCollectionCount")
                val realCollectionCount: Int, // 3003
                @SerializedName("replyCount")
                val replyCount: Int, // 254
                @SerializedName("shareCount")
                val shareCount: Int // 31629
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
                    val category: String, // 开胃
                    @SerializedName("collected")
                    val collected: Boolean, // false
                    @SerializedName("consumption")
                    val consumption: Consumption,
                    @SerializedName("cover")
                    val cover: Cover,
                    @SerializedName("dataType")
                    val dataType: String, // VideoBeanForClient
                    @SerializedName("date")
                    val date: Long, // 1475064845000
                    @SerializedName("description")
                    val description: String, // 日食记 |  耳光炒饭 & 烤茄子 金黄的虾油，酥软的茄肉。融化在漫长时光里，给予最朴实的满足。
                    @SerializedName("descriptionEditor")
                    val descriptionEditor: String, // 日食记 |  耳光炒饭 & 烤茄子 金黄的虾油，酥软的茄肉。融化在漫长时光里，给予最朴实的满足。
                    @SerializedName("descriptionPgc")
                    val descriptionPgc: String, // 日食记 |  耳光炒饭&烤茄子 金黄的虾油，酥软的茄肉。融化在漫长时光里，给予最朴实的满足。
                    @SerializedName("duration")
                    val duration: Int, // 282
                    @SerializedName("favoriteAdTrack")
                    val favoriteAdTrack: Any, // null
                    @SerializedName("id")
                    val id: Int, // 9812
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
                    val playUrl: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9812&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=
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
                    @SerializedName("releaseTime")
                    val releaseTime: Long, // 1475064845000
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
                    val src: Int, // 7
                    @SerializedName("subtitles")
                    val subtitles: List<Any>,
                    @SerializedName("tags")
                    val tags: List<Tag>,
                    @SerializedName("thumbPlayUrl")
                    val thumbPlayUrl: String,
                    @SerializedName("title")
                    val title: String, // 我心目中排行第一的无敌炒饭
                    @SerializedName("titlePgc")
                    val titlePgc: String, // 我心目中排行第一的无敌炒饭
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
                        val description: String, // 治愈你心和胃的日食记：） 快加我的微信公众号【日食记】，否则我就……求求你加我！ 微博 @日食记 @酥饼大人
                        @SerializedName("expert")
                        val expert: Boolean, // false
                        @SerializedName("follow")
                        val follow: Follow,
                        @SerializedName("icon")
                        val icon: String, // http://ali-img.kaiyanapp.com/2faf2139c4b655e56a54bdb2ee06e0b4.jpeg
                        @SerializedName("id")
                        val id: Int, // 22
                        @SerializedName("ifPgc")
                        val ifPgc: Boolean, // true
                        @SerializedName("latestReleaseTime")
                        val latestReleaseTime: Long, // 1681460136000
                        @SerializedName("link")
                        val link: String, // http://weibo.com/rishiji?from=myfollow_all
                        @SerializedName("name")
                        val name: String, // 日食记
                        @SerializedName("recSort")
                        val recSort: Int, // 0
                        @SerializedName("shield")
                        val shield: Shield,
                        @SerializedName("videoNum")
                        val videoNum: Int // 436
                    ) {
                        data class Follow(
                            @SerializedName("followed")
                            val followed: Boolean, // false
                            @SerializedName("itemId")
                            val itemId: Int, // 22
                            @SerializedName("itemType")
                            val itemType: String // author
                        )

                        data class Shield(
                            @SerializedName("itemId")
                            val itemId: Int, // 22
                            @SerializedName("itemType")
                            val itemType: String, // author
                            @SerializedName("shielded")
                            val shielded: Boolean // false
                        )
                    }

                    data class Consumption(
                        @SerializedName("collectionCount")
                        val collectionCount: Int, // 65112
                        @SerializedName("realCollectionCount")
                        val realCollectionCount: Int, // 9397
                        @SerializedName("replyCount")
                        val replyCount: Int, // 427
                        @SerializedName("shareCount")
                        val shareCount: Int // 61295
                    )

                    data class Cover(
                        @SerializedName("blurred")
                        val blurred: String, // http://ali-img.kaiyanapp.com/13a5f9f0c9a234fb006469f10d7648f8.jpeg?imageMogr2/quality/60
                        @SerializedName("detail")
                        val detail: String, // http://ali-img.kaiyanapp.com/5293111bfcc6275fc90c16cbf06fe5c9.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("feed")
                        val feed: String, // http://ali-img.kaiyanapp.com/5293111bfcc6275fc90c16cbf06fe5c9.jpeg?imageMogr2/quality/60/format/jpg
                        @SerializedName("homepage")
                        val homepage: String, // http://img.kaiyanapp.com/309dc1369d3d3db08fbc50ff228cbb68.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
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
                        val url: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9812&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss&udid=
                        @SerializedName("urlList")
                        val urlList: List<Url>,
                        @SerializedName("width")
                        val width: Int // 854
                    ) {
                        data class Url(
                            @SerializedName("name")
                            val name: String, // aliyun
                            @SerializedName("size")
                            val size: Int, // 19366642
                            @SerializedName("url")
                            val url: String // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=9812&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss&udid=
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
                        val actionUrl: String, // eyepetizer://tag/20/?title=%E9%A3%8E%E5%91%B3%E5%B8%82%E9%9B%86
                        @SerializedName("adTrack")
                        val adTrack: Any, // null
                        @SerializedName("bgPicture")
                        val bgPicture: String, // http://img.kaiyanapp.com/2c869d91d5db6ecf1c8c46af0f448719.png?imageMogr2/quality/60/format/jpg
                        @SerializedName("childTagIdList")
                        val childTagIdList: Any, // null
                        @SerializedName("childTagList")
                        val childTagList: Any, // null
                        @SerializedName("communityIndex")
                        val communityIndex: Int, // 0
                        @SerializedName("desc")
                        val desc: String, // 每日美食实验，带你感受味觉巅峰瞬间
                        @SerializedName("haveReward")
                        val haveReward: Boolean, // false
                        @SerializedName("headerImage")
                        val headerImage: String, // http://img.kaiyanapp.com/5748574edf96949c04ad382c46a4a2fd.png?imageMogr2/quality/60/format/jpg
                        @SerializedName("id")
                        val id: Int, // 20
                        @SerializedName("ifNewest")
                        val ifNewest: Boolean, // false
                        @SerializedName("name")
                        val name: String, // 风味市集
                        @SerializedName("newestEndTime")
                        val newestEndTime: Any, // null
                        @SerializedName("tagRecType")
                        val tagRecType: String // IMPORTANT
                    )

                    data class VideoPosterBean(
                        @SerializedName("fileSizeStr")
                        val fileSizeStr: String, // 2.78MB
                        @SerializedName("scale")
                        val scale: Double, // 0.725
                        @SerializedName("url")
                        val url: String // http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/ed2b697187e89523d3a3def6808491bf.mp4
                    )

                    data class WebUrl(
                        @SerializedName("forWeibo")
                        val forWeibo: String, // http://wandou.im/31wtnp
                        @SerializedName("raw")
                        val raw: String // http://www.eyepetizer.net/detail.html?vid=9812
                    )
                }
            }

            data class Cover(
                @SerializedName("blurred")
                val blurred: String, // http://ali-img.kaiyanapp.com/92b71bd4e4dd88e3f731ff8874e9bd6e.jpeg?imageMogr2/quality/100
                @SerializedName("detail")
                val detail: String, // http://ali-img.kaiyanapp.com/2409e4eb72e0b2d74f37b5ed02bfae9c.jpeg?imageMogr2/quality/100
                @SerializedName("feed")
                val feed: String, // http://ali-img.kaiyanapp.com/2409e4eb72e0b2d74f37b5ed02bfae9c.jpeg?imageMogr2/quality/100
                @SerializedName("homepage")
                val homepage: String, // http://img.kaiyanapp.com/cbdda1ba4e7c5e7d267311b1877a97db.png?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
                @SerializedName("sharing")
                val sharing: Any // null
            )

            data class Header(
                @SerializedName("actionUrl")
                val actionUrl: String, // eyepetizer://pgc/detail/22/?title=%E6%97%A5%E9%A3%9F%E8%AE%B0&userType=PGC&tabIndex=1
                @SerializedName("cover")
                val cover: Any, // null
                @SerializedName("description")
                val description: String, // #开胃 / 收录于 每日编辑精选
                @SerializedName("font")
                val font: Any, // null
                @SerializedName("icon")
                val icon: String, // http://ali-img.kaiyanapp.com/2faf2139c4b655e56a54bdb2ee06e0b4.jpeg
                @SerializedName("iconType")
                val iconType: String, // round
                @SerializedName("id")
                val id: Int, // 9812
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
                val time: Long, // 1475064845000
                @SerializedName("title")
                val title: String // 日食记
            )

            data class PlayInfo(
                @SerializedName("height")
                val height: Int, // 480
                @SerializedName("name")
                val name: String, // 标清
                @SerializedName("type")
                val type: String, // normal
                @SerializedName("url")
                val url: String, // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=5614&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss&udid=
                @SerializedName("urlList")
                val urlList: List<Url>,
                @SerializedName("width")
                val width: Int // 854
            ) {
                data class Url(
                    @SerializedName("name")
                    val name: String, // aliyun
                    @SerializedName("size")
                    val size: Int, // 18753905
                    @SerializedName("url")
                    val url: String // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=5614&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss&udid=
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
                val actionUrl: String, // eyepetizer://tag/20/?title=%E9%A3%8E%E5%91%B3%E5%B8%82%E9%9B%86
                @SerializedName("adTrack")
                val adTrack: Any, // null
                @SerializedName("bgPicture")
                val bgPicture: String, // http://img.kaiyanapp.com/2c869d91d5db6ecf1c8c46af0f448719.png?imageMogr2/quality/60/format/jpg
                @SerializedName("childTagIdList")
                val childTagIdList: Any, // null
                @SerializedName("childTagList")
                val childTagList: Any, // null
                @SerializedName("communityIndex")
                val communityIndex: Int, // 0
                @SerializedName("desc")
                val desc: String, // 每日美食实验，带你感受味觉巅峰瞬间
                @SerializedName("haveReward")
                val haveReward: Boolean, // false
                @SerializedName("headerImage")
                val headerImage: String, // http://img.kaiyanapp.com/5748574edf96949c04ad382c46a4a2fd.png?imageMogr2/quality/60/format/jpg
                @SerializedName("id")
                val id: Int, // 20
                @SerializedName("ifNewest")
                val ifNewest: Boolean, // false
                @SerializedName("name")
                val name: String, // 风味市集
                @SerializedName("newestEndTime")
                val newestEndTime: Any, // null
                @SerializedName("tagRecType")
                val tagRecType: String // IMPORTANT
            )

            data class VideoPosterBean(
                @SerializedName("fileSizeStr")
                val fileSizeStr: String, // 3.04MB
                @SerializedName("scale")
                val scale: Double, // 0.725
                @SerializedName("url")
                val url: String // http://eyepetizer-videos.oss-cn-beijing.aliyuncs.com/video_poster_share/def1e947c0ff4994dcfaaf7bfb1a6f57.mp4
            )

            data class WebUrl(
                @SerializedName("forWeibo")
                val forWeibo: String, // http://wandou.im/1j96gs
                @SerializedName("raw")
                val raw: String // http://www.eyepetizer.net/detail.html?vid=5614
            )
        }
    }
}