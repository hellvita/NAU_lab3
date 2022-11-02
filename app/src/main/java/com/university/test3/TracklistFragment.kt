package com.university.test3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TracklistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TracklistFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val dataModel: DataModel by activityViewModels()
    private val dataModel2: DataModel2 by activityViewModels()
    private val dataModel3: DataModel3 by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tracklist, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TracklistFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TracklistFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val args: TracklistFragmentArgs by navArgs()
        //val album = args.albumTitle
        val tvName = view.findViewById<TextView>(R.id.fragment2Title)
        val imgView = view.findViewById<ImageView>(R.id.tracklistCover)
        val recView = view.findViewById<RecyclerView>(R.id.recView2)
        recView.layoutManager = LinearLayoutManager(context)
        recView.setHasFixedSize(true)
        lateinit var titles: ArrayList<String>
        var titlesArrayList: ArrayList<TrackTitles> = arrayListOf<TrackTitles>()
        var songArray: ArrayList<String> = arrayListOf("", "", "", "", "", "")
        var subStr: String = ""
        lateinit var fullString: String
        var ind: Int = 0
        lateinit var adapter: tracklistAdapter

        dataModel.str.observe(activity as LifecycleOwner, {
            tvName.text = it
        })
        dataModel2.img.observe(activity as LifecycleOwner, {
            imgView.setImageResource(it)
        })
        dataModel3.tracklist.observe(activity as LifecycleOwner, {
            fullString = it
        })

        ind = fullString.indexOf('1')
        subStr = fullString.substring(ind)
        songArray[0] = subStr.substringBefore(",")
        ind = subStr.indexOf('2')
        subStr = subStr.substring(ind)
        songArray[1] = subStr.substringBefore(",")
        ind = subStr.indexOf('3')
        subStr = subStr.substring(ind)
        songArray[2] = subStr.substringBefore(",")
        ind = subStr.indexOf('4')
        subStr = subStr.substring(ind)
        songArray[3] = subStr.substringBefore(",")
        ind = subStr.indexOf('5')
        subStr = subStr.substring(ind)
        songArray[4] = subStr.substringBefore(",")
        ind = subStr.indexOf('6')
        if (ind > 0) {
            subStr = subStr.substring(ind)
            songArray[5] = subStr.substringBefore(']')
        }
        else songArray[4] = subStr.substringBefore(']')
        titles = arrayListOf(songArray[0], songArray[1], songArray[2], songArray[3], songArray[4], songArray[5])
        for (i in titles.indices){
            val ListItems = TrackTitles(titles[i])
            titlesArrayList.add(ListItems)
        }
        adapter = tracklistAdapter(titlesArrayList)
        recView.adapter = adapter
        //tvName.text = album
    }
}