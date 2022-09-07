package com.xu.commit;

/**
 * From https://github.com/commitizen/conventional-commit-types
 *
 * @author Damien Arrachequesne
 */
public enum ChangeType {
    INIT("Init", "项目初始化"),
    FEAT("Features", "添加新特性"),
    FIX("Bug Fixes", "修复bug"),
    DOCS("Documentation", "仅仅修改文档"),
    STYLE("Styles", "仅仅修改了空格、格式缩进、逗号等等，不改变代码逻辑"),
    REFACTOR("Code Refactoring", "代码重构，没有加新功能或修复bug"),
    PERF("Performance Improvements", "优化相关，比如提升性能、体验"),
    TEST("Tests", "增加测试用例"),
    BUILD("Builds", "依赖相关的内容"),
    CI("Continuous Integrations", "ci配置相关 例如对k8s，docker的配置文件的修改"),
    CHORE("Chores", "改变构建流程、或者增加依赖库、工具等"),
    REVERT("Reverts", "回滚到上一个版本");

    public final String title;
    public final String description;

    ChangeType(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String label() {
        return this.name().toLowerCase();
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.label(), this.description);
    }
}
