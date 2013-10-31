package edu.mype.prismandr.client;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NextTokenBuilder {
    private List<Long> skipIds = new LinkedList<>();
    private List<ViewedData> viewedData = new LinkedList<>();

    public NextTokenBuilder addSkipId(Long skipId) {
        this.skipIds.add(skipId);
        return this;
    }

    public NextTokenBuilder addSkipIds(Long ... skipIds) {
        this.skipIds.addAll(Arrays.asList(skipIds));
        return this;
    }

    public NextTokenBuilder addViewedData(ViewedData viewedData) {
        this.viewedData.add(viewedData);
        return this;
    }

    public NextToken createNextToken() {
        return new NextToken(skipIds, viewedData);
    }
}