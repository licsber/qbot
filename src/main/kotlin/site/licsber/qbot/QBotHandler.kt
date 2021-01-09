package site.licsber.qbot

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.mamoe.mirai.BotFactory
import net.mamoe.mirai.alsoLogin
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
}
