package jsp.death

import android.util.Log
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.FormElement

object Parser {
    private val loginUrl = "http://116.126.97.126:12345/BBS/login.jsp"
    private lateinit var session: Map<String, String>
    private var count = 0
    fun login() {
        Thread {
            val res = Jsoup.connect(loginUrl)
                .method(Connection.Method.GET)
                .execute()
            session = res.cookies()

            val form = res.parse().select("form").first() as FormElement
            form.let {
                it.select("[name=userID]").`val`("zoz")
                it.select("[name=userPassword]").`val`("wodud")
                it.submit()
                    .cookies(session)
                    .post()
            }


        }.start()
    }

    fun writePost() {
        Thread {
            val write = Jsoup.connect("http://116.126.97.126:12345/BBS/write.jsp")
                .cookies(session)
                .method(Connection.Method.POST)
                .execute()
            val writeForm = write.parse().select("form").first() as FormElement
            Log.e("form", writeForm.html())
            writeForm.let {
                it.select("[name=bbsTitle]").`val`("앙기모찌$count")
                it.select("[name=bbsContent]").`val`("asd$count")
                it.submit()
                    .cookies(session)
                    .post()
            }
            count++
        }.start()
    }
}