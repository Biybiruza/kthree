package com.biybiruza.datalifecenter.ui.admin.add

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.biybiruza.kthree.MySharedReport
import com.biybiruza.kthree.R
import com.biybiruza.kthree.data.Post
import com.biybiruza.kthree.databinding.FragmentAddCourseBinding
import com.google.gson.Gson


class AddCourseFragment : Fragment(R.layout.fragment_add_course) {

    private lateinit var binding: FragmentAddCourseBinding
    private lateinit var mySharedReport: MySharedReport
    val postList = arrayListOf<Post>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddCourseBinding.bind(view)
        mySharedReport = MySharedReport(requireActivity(), Gson())

        binding.apply {
            send.setOnClickListener {
                val models: MutableList<Post> = ArrayList<Post>()

                if (mySharedReport.getList("key", Post::class.java) != null) {
                    models.addAll(mySharedReport.getList("key", Post::class.java))
                }
                models.add(Post(etLocation.text.toString(),etDescription.text.toString()))
                mySharedReport.putList("post",models)
                Toast.makeText(requireActivity(),"Saved",Toast.LENGTH_SHORT).show()
            }
        }
    }
}