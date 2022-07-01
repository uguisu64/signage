import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import dataclass.WhetherData

object Whether {
    var weekWhether = listOf<WhetherData>()

    fun getData() : Boolean {
        val url = "https://www.jma.go.jp/bosai/forecast/data/forecast/130000.json"
        var data = ""
        var success = false
        url.httpGet().responseString {_, _, result ->
            when(result) {
                is Result.Success -> {
                    data = result.get()
                }
                is Result.Failure -> {
                    success = false
                }
            }
        }

        return success
    }
}