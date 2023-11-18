package com.biybiruza.kthree.ui.notification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.biybiruza.kthree.MySharedReport
import com.biybiruza.kthree.R
import com.biybiruza.kthree.data.Post
import com.biybiruza.kthree.databinding.FragmentNotificationBinding
import com.google.gson.Gson

class NotificationFragment : Fragment(R.layout.fragment_notification) {

    private lateinit var binding: FragmentNotificationBinding
    private lateinit var adapterReport: AdapterReport
    private lateinit var mySharedReport: MySharedReport
    private lateinit var list: ArrayList<Post>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNotificationBinding.bind(view)
        adapterReport = AdapterReport()
        list = arrayListOf()
        mySharedReport = MySharedReport(requireActivity(), Gson())

        if (mySharedReport.getList("post", Post::class.java) != null) {
            list.clear()

            list.addAll(mySharedReport.getList("post", Post::class.java))


            binding.rvReport.layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
            adapterReport.postList = list
            binding.rvReport.adapter = adapterReport
        } else {
            Toast.makeText(requireActivity(), "Not add Report yet", Toast.LENGTH_SHORT).show()
        }

    }

}