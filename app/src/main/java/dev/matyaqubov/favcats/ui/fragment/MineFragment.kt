package dev.matyaqubov.favcats.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.matyaqubov.favcats.R


class MineFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return initViews(inflater.inflate(R.layout.fragment_mine, container, false))
    }

    private fun initViews(view: View): View {
        return view
    }
}