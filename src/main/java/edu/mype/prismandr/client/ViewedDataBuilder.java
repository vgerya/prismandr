package edu.mype.prismandr.client;

public class ViewedDataBuilder {
    private long documentId;
    private String feedId;
    private long dwell;

    public ViewedDataBuilder setDocumentId(long documentId) {
        this.documentId = documentId;
        return this;
    }

    public ViewedDataBuilder setFeedId(String feedId) {
        this.feedId = feedId;
        return this;
    }

    public ViewedDataBuilder setDwell(long dwell) {
        this.dwell = dwell;
        return this;
    }

    public ViewedData createViewedData() {
        return new ViewedData(documentId, feedId, dwell);
    }
}