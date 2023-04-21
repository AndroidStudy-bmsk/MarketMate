package org.bmsk.marketmate.remote

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import org.bmsk.marketmate.model.Coupon
import org.bmsk.marketmate.model.Empty
import org.bmsk.marketmate.model.FullAd
import org.bmsk.marketmate.model.Horizontal
import org.bmsk.marketmate.model.Image
import org.bmsk.marketmate.model.ListItem
import org.bmsk.marketmate.model.Sale
import org.bmsk.marketmate.model.SellItem
import org.bmsk.marketmate.model.ViewPager
import org.bmsk.marketmate.model.ViewType
import java.lang.Exception
import java.lang.reflect.Type

class ListItemDeserializer : JsonDeserializer<ListItem> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): ListItem {
        // json에서 viewType을 바라보고 어떤 object, data class를 반환할 것인지 작업
        val viewTypeName = json.asJsonObject.getAsJsonPrimitive("viewType").asString
        // ListItem 안에도 ListItem이 존재하기 때문에 이 부분을 역직렬화 해 주어야 한다.
        val gson = GsonBuilder()
            .registerTypeAdapter(ListItem::class.java, ListItemDeserializer())
            .create()
        // 이제 실질적으로 어떤 뷰타입의 어떤 오브젝트(데이터 클래스)를 반환할 것인지를 추가한다.
        return try {
            when(viewTypeName) {
                ViewType.VIEW_PAGER.name -> gson.fromJson(json, ViewPager::class.java)
                ViewType.HORIZONTAL.name -> gson.fromJson(json, Horizontal::class.java)
                ViewType.FULL_AD.name -> gson.fromJson(json, FullAd::class.java)

                ViewType.SELL_ITEM.name -> gson.fromJson(json, SellItem::class.java)
                ViewType.IMAGE.name -> gson.fromJson(json, Image::class.java)
                ViewType.SALE.name -> gson.fromJson(json, Sale::class.java)
                ViewType.COUPON.name -> gson.fromJson(json, Coupon::class.java)

                else -> gson.fromJson(json, Empty::class.java)
            }
        } catch (e: Exception) {
            gson.fromJson(json, Empty::class.java)
        }
    }
}