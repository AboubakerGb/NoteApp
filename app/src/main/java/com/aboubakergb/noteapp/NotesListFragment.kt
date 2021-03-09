package com.aboubakergb.noteapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class NotesListFragment : Fragment(R.layout.fragment_notes_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.notelist_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.mi_addNote-> {
                view?.findNavController()?.navigate(R.id.addNoteFragment)
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }

    }
