package com.example.uxdesign.feature.board

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uxdesign.R
import com.example.uxdesign.data.PostDetail
import com.example.uxdesign.databinding.ActivityPostBinding

class PostActivity : AppCompatActivity() {

    lateinit var binding : ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setPost()
        setBackBtn()
    }

    private fun setBackBtn() {
        binding.btnPostBack.setOnClickListener {
            finish()
        }
    }

    private fun findIntent(): PostDetail? {
        val title = intent.getStringExtra("title")
        val time = intent.getStringExtra("time")
        val writer = intent.getStringExtra("writer")
        val date = intent.getStringExtra("date")

        if (title != null && time != null && writer != null && date != null)
            return PostDetail(title, date, time, writer, "")
        else return null
    }

    private fun setPost() {
        var postDetail = findIntent()
        if (postDetail == null) postDetail = PostDetail("", "", "", "", "")
        else postDetail.content = "게시물 내용을 작성하세요~"
        binding.apply {
            tvPostTitle.text = postDetail.title
            tvPostWriter.text = postDetail.writer
            tvPostTime.text = "${postDetail.date} ${postDetail.time}"
        }
    }

}