package site.licsber.qbot

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.alsoLogin
import net.mamoe.mirai.message.data.AtAll
import net.mamoe.mirai.message.data.PlainText
import net.mamoe.mirai.message.data.buildMessageChain
import org.springframework.stereotype.Component

@Component
class QBotHandler(config: UserConfig) {
    private val bot = BotFactory.newBot(config.qid, config.password) {
        fileBasedDeviceInfo()
    }

    init {
        GlobalScope.launch {
            bot.alsoLogin()
        }
    }

    suspend fun sendFriendMsg(friendId: Long, msg: String) {
        bot.getFriend(friendId)?.sendMessage(msg)
    }

    suspend fun sendGroupMsg(groupId: Long, msg: String) {
        bot.getGroup(groupId)?.sendMessage(msg)
    }

    suspend fun sendGroupAtAllMsg(groupId: Long, msg: String) {
        bot.getGroup(groupId)?.sendMessage(buildMessageChain {
            +PlainText(msg)
            +AtAll
        })
    }
}
