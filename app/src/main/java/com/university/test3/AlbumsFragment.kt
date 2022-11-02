package com.university.test3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AlbumsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AlbumsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val dataModel: DataModel by activityViewModels()
    private val dataModel2: DataModel2 by activityViewModels()
    private val dataModel3: DataModel3 by activityViewModels()

    private lateinit var recView: RecyclerView
    private lateinit var namesList: ArrayList<AlbumNames>

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
        return inflater.inflate(R.layout.fragment_albums, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AlbumsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AlbumsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInit()
        recView = view.findViewById<RecyclerView>(R.id.recView)
        recView.layoutManager = LinearLayoutManager(context)
        recView.setHasFixedSize(true)
        recView.adapter = context?.let { namesListAdapter(it,namesList){
           val AlbumTitle: String = it.name
           val AlbumCover: Int = it.cover
           val AlbumTrackList: List<String> = it.trackList
           val action = AlbumsFragmentDirections
               .actionAlbumsFragmentToTracklistFragment(AlbumTitle)
            dataModel.str.value = AlbumTitle
            dataModel2.img.value = AlbumCover
            dataModel3.tracklist.value = AlbumTrackList.toString()
            /*
            for (i in AlbumTrackList.indices){
                dataModel3.tracklist.value = AlbumTrackList[i].toString()
            }
             */
            findNavController().navigate(action)
        } }
    }

    private fun dataInit(){
        val tracklist1 = arrayListOf<String>(
            getString(R.string.t_ep1_song1),
            getString(R.string.t_ep1_song2),
            getString(R.string.t_ep1_song3),
            getString(R.string.t_ep1_song4),
            getString(R.string.t_ep1_song5),
            getString(R.string.t_ep1_song6)
        )
        val tracklist2 = arrayListOf<String>(
            getString(R.string.t_ep2_song1),
            getString(R.string.t_ep2_song2),
            getString(R.string.t_ep2_song3),
            getString(R.string.t_ep2_song4),
            getString(R.string.t_ep2_song5),
            getString(R.string.t_ep2_song6)
        )
        val tracklist3 = arrayListOf<String>(
            getString(R.string.t_ep3_song1),
            getString(R.string.t_ep3_song2),
            getString(R.string.t_ep3_song3),
            getString(R.string.t_ep3_song4),
            getString(R.string.t_ep3_song5),
            getString(R.string.t_ep3_song6)
        )
        val tracklist4 = arrayListOf<String>(
            getString(R.string.t_eplg_song1),
            getString(R.string.t_eplg_song2),
            getString(R.string.t_eplg_song3),
            getString(R.string.t_eplg_song4),
            getString(R.string.t_eplg_song5)
        )
        namesList = arrayListOf<AlbumNames>(
            AlbumNames(
                R.drawable.cov1,
                getString(R.string.treas_ep1),
                tracklist1
            ),
            AlbumNames(
                R.drawable.cov2,
                getString(R.string.treas_ep2),
                tracklist2
            ),
            AlbumNames(
                R.drawable.cov3,
                getString(R.string.treas_ep3),
                tracklist3
            ),
            AlbumNames(
                R.drawable.cov_eplg,
                getString(R.string.treas_epilogue),
                tracklist4
            )
        )
    }
}