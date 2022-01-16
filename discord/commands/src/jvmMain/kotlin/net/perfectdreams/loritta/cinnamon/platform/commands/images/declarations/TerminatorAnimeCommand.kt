package net.perfectdreams.loritta.cinnamon.platform.commands.images.declarations

import net.perfectdreams.loritta.cinnamon.i18n.I18nKeysData
import net.perfectdreams.loritta.cinnamon.platform.commands.CommandCategory
import net.perfectdreams.loritta.cinnamon.platform.commands.SlashCommandDeclarationWrapper
import net.perfectdreams.loritta.cinnamon.platform.commands.images.TerminatorAnimeExecutor

object TerminatorAnimeCommand : SlashCommandDeclarationWrapper {
    val I18N_PREFIX = I18nKeysData.Commands.Command.Terminatoranime

    override fun declaration() = slashCommand(listOf("terminatoranime", "terminator", "animeterminator"), CommandCategory.IMAGES, I18N_PREFIX.Description) {
        executor = TerminatorAnimeExecutor
    }
}