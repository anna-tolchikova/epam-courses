package by.bsuir.parsersservlet.patterncommand.enums;

import by.bsuir.parsersservlet.patterncommand.*;

public enum CommandEnum {

    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },
    PARSEDOM {
        {
            this.command = new ParseCommand();
        }
    },
    PARSESAX {
        {
            this.command = new ParseCommand();
        }
    },
    PARSESTAX {
        {
            this.command = new ParseCommand();
        }
    };
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}