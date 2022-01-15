package net.perfectdreams.loritta.cinnamon.platform.commands.options

import net.perfectdreams.discordinteraktions.common.entities.Channel
import net.perfectdreams.discordinteraktions.common.entities.Role
import net.perfectdreams.discordinteraktions.common.entities.User
import net.perfectdreams.i18nhelper.core.keydata.StringI18nData
import net.perfectdreams.loritta.cinnamon.common.images.ImageReference

open class CommandOptions {
    companion object {
        val NO_OPTIONS = object: CommandOptions() {}
    }

    val arguments = mutableListOf<CommandOption<*>>()

    fun string(name: String, description: StringI18nData) = argument<String>(
        CommandOptionType.String,
        name,
        description
    )

    fun optionalString(name: String, description: StringI18nData) = argument<String?>(
        CommandOptionType.NullableString,
        name,
        description
    )

    fun integer(name: String, description: StringI18nData) = argument<Long>(
        CommandOptionType.Integer,
        name,
        description
    )

    fun optionalInteger(name: String, description: StringI18nData) = argument<Long?>(
        CommandOptionType.NullableInteger,
        name,
        description
    )

    fun number(name: String, description: StringI18nData) = argument<Double>(
        CommandOptionType.Number,
        name,
        description
    )

    fun optionalNumber(name: String, description: StringI18nData) = argument<Double?>(
        CommandOptionType.NullableNumber,
        name,
        description
    )

    fun boolean(name: String, description: StringI18nData) = argument<Boolean>(
        CommandOptionType.Bool,
        name,
        description
    )

    fun optionalBoolean(name: String, description: StringI18nData) = argument<Boolean?>(
        CommandOptionType.NullableBool,
        name,
        description
    )

    fun user(name: String, description: StringI18nData) = argument<User>(
        CommandOptionType.User,
        name,
        description
    )

    fun optionalUser(name: String, description: StringI18nData) = argument<User?>(
        CommandOptionType.NullableUser,
        name,
        description
    )

    fun channel(name: String, description: StringI18nData) = argument<Channel>(
        CommandOptionType.Channel,
        name,
        description
    )

    fun optionalChannel(name: String, description: StringI18nData) = argument<Channel?>(
        CommandOptionType.NullableChannel,
        name,
        description
    )

    fun role(name: String, description: StringI18nData) = argument<Role>(
        CommandOptionType.Role,
        name,
        description
    )

    fun optionalRole(name: String, description: StringI18nData) = argument<Role?>(
        CommandOptionType.NullableRole,
        name,
        description
    )

    fun stringList(name: String, description: StringI18nData, minimum: Int? = null, maximum: Int? = null) = ListCommandOptionBuilder<List<String>>(
        CommandOptionType.StringList,
        name,
        description,
        minimum,
        maximum
    )

    fun userList(name: String, description: StringI18nData, minimum: Int? = null, maximum: Int? = null) = ListCommandOptionBuilder<List<User>>(
        CommandOptionType.UserList,
        name,
        description,
        minimum,
        maximum
    )

    fun imageReference(name: String, description: StringI18nData) = argument<ImageReference>(
        CommandOptionType.ImageReference,
        name,
        description
    )

    fun <T> argument(type: CommandOptionType, name: String, description: StringI18nData) = CommandOptionBuilder<T>(
        type,
        name,
        description,
        mutableListOf()
    )

    fun <T> CommandOptionBuilder<T>.register(): CommandOption<T> {
        if (arguments.any { it.name == this.name })
            throw IllegalArgumentException("Duplicate argument!")

        val option = CommandOption(
            this.type,
            this.name,
            this.description,
            this.choices
        )

        arguments.add(option)
        return option
    }

    fun <T> ListCommandOptionBuilder<T>.register(): ListCommandOption<T> {
        if (arguments.any { it.name == this.name })
            throw IllegalArgumentException("Duplicate argument!")

        val option = ListCommandOption<T>(
            this.type,
            this.name,
            this.description,
            this.minimum,
            this.maximum
        )

        arguments.add(option)
        return option
    }
}