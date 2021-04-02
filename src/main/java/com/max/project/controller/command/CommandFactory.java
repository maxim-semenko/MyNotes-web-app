package com.max.project.controller.command;

import com.max.project.context.CommandType;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.Optional;

@Log4j2
public class CommandFactory {

    /**
     * Method that returns {@link Command}.
     *
     * @param command {@link String} const value
     * @return {@link Command} command
     */
    public static Command getCommand(final String command) {
        log.info("Get command " + command);
        return Arrays.stream(CommandType.values())
                .filter(enumCommand -> enumCommand.getUrl().equals(command))
                .findFirst().map(CommandType::getCommand).orElse(null);
    }
}
