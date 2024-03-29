package com.example.stayfit;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Article {

    @SerializedName("source")
    @Expose
    private Source source;

    @SerializedName("author")
    @Expose private String author;

    @SerializedName("title")
    @Expose private String title;

    @SerializedName("description")
    @Expose private String description;

    @SerializedName("url")
    @Expose private String url;

    @SerializedName("urlToImage")
    @Expose private String urlToImage;

    @SerializedName("publishedAt")
    @Expose private String publishedAt;

    @SerializedName("content")
    @Expose private String content;

    public Article(Source source, String author, String title, String description, String url,
                   String urlToImage, String publishedAt, String content) {
        this.source = source;
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return getSource().equals(article.getSource()) &&
                Objects.equals(getAuthor(), article.getAuthor()) &&
                Objects.equals(getTitle(), article.getTitle()) &&
                Objects.equals(getDescription(), article.getDescription()) &&
                getUrl().equals(article.getUrl()) &&
                Objects.equals(getUrlToImage(), article.getUrlToImage()) &&
                Objects.equals(getPublishedAt(), article.getPublishedAt()) &&
                Objects.equals(getContent(), article.getContent());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public int hashCode() {
        return Objects.hash(
                getSource(), getAuthor(), getTitle(), getDescription(), getUrl(),
                getUrlToImage(), getPublishedAt(), getContent());
    }
}

