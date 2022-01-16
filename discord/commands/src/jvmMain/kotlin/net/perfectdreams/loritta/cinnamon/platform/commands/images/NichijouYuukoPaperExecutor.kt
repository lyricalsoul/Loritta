package net.perfectdreams.loritta.cinnamon.platform.commands.images

import net.perfectdreams.gabrielaimageserver.client.GabrielaImageServerClient
import net.perfectdreams.loritta.cinnamon.platform.commands.SlashCommandExecutorDeclaration
import net.perfectdreams.loritta.cinnamon.platform.commands.images.base.GabrielaImageServerSingleCommandBase
import net.perfectdreams.loritta.cinnamon.platform.commands.images.base.SingleImageOptions

class NichijouYuukoPaperExecutor(
    client: GabrielaImageServerClient
) : GabrielaImageServerSingleCommandBase(
    client,
    { client.images.nichijouYuukoPaper(it) },
    "nichijou_yuuko_paper.gif"
) {
    companion object : SlashCommandExecutorDeclaration(NichijouYuukoPaperExecutor::class) {
        override val options = SingleImageOptions
    }
}