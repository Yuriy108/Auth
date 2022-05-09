package com.example.auth;

public class Message {



        private String author;
        private String message;
        private long data;

        public long getData() {
            return data;
        }

        public void setData(long data) {
            this.data = data;
        }

        public Message(String author, String message, long data) {
            this.author = author;
            this.message = message;
            this.data = data;
        }

        public Message(String author, String message) {
            this.author = author;
            this.message = message;
        }

        public Message() {
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }



