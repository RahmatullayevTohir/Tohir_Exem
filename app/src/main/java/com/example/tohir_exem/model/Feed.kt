package com.example.tohir_exem.model

class Feed {
    var isHeader:Boolean = false
    var post: Restaurant? = null
    var stories:ArrayList<Catigory> = ArrayList<Catigory>()

    constructor(){
        this.isHeader = true
    }
    constructor(stories:ArrayList<Catigory>){
        this.stories = stories
        this.isHeader = false
    }
    constructor(post: Restaurant){
        this.post = post
        this.isHeader = false
    }


}