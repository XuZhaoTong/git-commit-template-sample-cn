package com.xu.commit;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CommitMessage {
    public static final Pattern COMMIT_FIRST_LINE_FORMAT = Pattern.compile("^([a-z]+)(\\((.+)\\))?: (.+)");
    private static final HashMap<String,String> COMMIT_TYPES =new HashMap<>(){{
        put("init","\uD83C\uDF89");
        put("feat","✨");
        put("fix","\uD83D\uDC1E");
        put("docs","\uD83D\uDCC3");
        put("style","\uD83C\uDF08");
        put("refactor","\uD83E\uDD84");
        put("perf","\uD83C\uDF88");
        put("test","\uD83E\uDDEA");
        put("build","\uD83D\uDD27");
        put("ci","\uD83D\uDC0E");
        put("chore","\uD83D\uDC33");
        put("revert","↩");
    }};
    private ChangeType changeType;
    private String  shortDescription;

    private CommitMessage() {
        this.shortDescription = "";
    }
    public CommitMessage(ChangeType changeType, String shortDescription) {
        this.changeType = changeType;
        this.shortDescription = shortDescription;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(COMMIT_TYPES.get(changeType.label()) + changeType.label());
        builder
                .append(": ")
                .append(shortDescription);
        return builder.toString();
    }


    public static CommitMessage parse(String message) {
        CommitMessage commitMessage = new CommitMessage();

        try {
            Matcher matcher = COMMIT_FIRST_LINE_FORMAT.matcher(message);
            if (!matcher.find()) return commitMessage;

            commitMessage.changeType = ChangeType.valueOf(matcher.group(1).toUpperCase());
            commitMessage.shortDescription = matcher.group(4);


        } catch (RuntimeException e) {}

        return commitMessage;
    }

    public ChangeType getChangeType() {
        return changeType;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}