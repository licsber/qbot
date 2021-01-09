package site.licsber.qbot

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MsgController(val qbot: QBotHandler) {
    @PostMapping("/fmsg/{id}")
    fun sendFriendMsg(@PathVariable id: Long, @RequestParam("msg") msg: String) {
        GlobalScope.launch {
            qbot.sendFriendMsg(id, msg)
        }
    }

    @PostMapping("/gmsg/{id}")
    fun sendGroupMsg(@PathVariable id: Long, @RequestParam("msg") msg: String) {
        GlobalScope.launch {
            qbot.sendGroupMsg(id, msg)
        }
    }

    @PostMapping("/amsg/{id}")
    fun sendGroupAtAllMsg(@PathVariable id: Long, @RequestParam("msg") msg: String) {
        GlobalScope.launch {
            qbot.sendGroupAtAllMsg(id, msg)
        }
    }
}
